'use strict';

angular.module('tagstered').factory('UserService',
		[ '$http', '$resource', '$log', function($http, $resource, $log) {

			var apiURL = '/tagstered/user/';

			return {
				getUser : getUser,
				createUser : createUser,
				createOrUpdateUser : createOrUpdateUser,
				addFollowedTag : addFollowedTag,
				removeFollowedTag : removeFollowedTag
			};

			function getUser(id, success, error) {
				$http({
					method : 'GET',
					url : apiURL + id,
					data : {},
					headers : {
						'Content-Type' : 'application/json'
					}
				}).then(success, error);
			}

			function createUser(id, token, success, error) {
				$http({
					method : 'POST',
					url : apiURL + id + '/' + token,
					data : {},
					headers : {
						'Content-Type' : 'application/json'
					}
				}).then(success, error);
			}
			
			function createOrUpdateUser(id, token, success, error) {
				$http({
					method : 'POST',
					url : apiURL + id + '/' + token + '/createOrUpdate',
					data : {},
					headers : {
						'Content-Type' : 'application/json'
					}
				}).then(success, error);
			}

			function addFollowedTag(id, tagName, success, error) {
				$http({
					method : 'PUT',
					url : apiURL + id + '/tag/' + tagName + '/add',
					data : {},
					headers : {
						'Content-Type' : 'application/json'
					}
				}).then(success, error);

			}

			function removeFollowedTag(id, tagName, success, error) {
				$http({
					method : 'PUT',
					url : apiURL + id + '/tag/' + tagName + '/remove',
					data : {},
					headers : {
						'Content-Type' : 'application/json'
					}
				}).then(success, error);
			}

		} ]);