'use strict';

angular.module('tagstered').controller(
		'TagsteredController',
		[
				'$scope',
				'$location',
				'$log',
				'$routeParams',
				'UserService',
				'InstagramTagService',
				'InstagramAuthService',
				function($scope, $location, $log, $routeParams, UserService,
						InstagramTagService, InstagramAuthService) {

					$scope.maxTagId = null;
					$scope.showLogin = true;
					$scope.accessToken = $location.hash().split('=')[1];
					
					if($scope.accessToken) {
						InstagramAuthService.getUserByAccessToken($scope.accessToken, function(response) {
							UserService.createOrUpdateUser(response.data.username, $scope.accessToken, function(response) {
								$scope.user = response.data;
								$scope.currentUserId = $scope.user.id;
								$scope.tags = $scope.user.followedTags;
								$scope.showLogin = false;
							}, function(response){
								console.log("createUser {} error");
								$scope.showCreateError = true;
							});
						}, function(data) {
							console.log("getUserByAccessToken {} error");
							$scope.showLoginError = true;
						});
					} 
					
					$scope.login = function() {
						InstagramAuthService.login(function(response) {
							$scope.showLogin = false;
						}, function(response) {
							$scope.showLogin = true;
							$scope.showLoginError = true;
						});
					}

					$scope.showTagRecentMedia = function(tagName) {
						$scope.selectedTagName = tagName;
						InstagramTagService.getRecentTagMedia(tagName,
								$scope.maxTagId, function(response) {
									$scope.images = response.data;
								}, function(data) {
									console.log("error");
								});
					};

					$scope.addNewTag = function(newTag) {
						UserService.addFollowedTag($scope.currentUserId,
								newTag, function(response) {
									$scope.user = response.data;
									$scope.tags = $scope.user.followedTags;
								}, function(response) {
									$log.error("addNewTag {} " + response);
								});
					};

					$scope.removeTag = function(tag) {
						UserService.removeFollowedTag($scope.currentUserId,
								tag, function(response) {
									$scope.user = response.data;
									$scope.tags = $scope.user.followedTags;
								}, function(response) {
									$log.error("addNewTag {} " + response);
								});
					};

					$scope.loadMore = function() {
						if ($scope.selectedTagName) {
							InstagramTagService.getRecentTagMedia(
									$scope.selectedTagName, $scope.maxTagId,
									function(response) {
										$scope.newImages = response.data;
										if ($scope.newImages.length > 0)
											$scope.images = $scope.images
													.concat($scope.newImages);
									}, function(data) {
										console.log("getRecentTagMedia{} error");
									});
						}

					};
				} ]);
