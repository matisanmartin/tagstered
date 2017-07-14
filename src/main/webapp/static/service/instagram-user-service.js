'use strict';

angular
		.module('tagstered')
		.factory(
				'InstagramUserService',
				[
						'$http',
						'$sce',
						function($http, $sce) {

							var apiURL = 'https://api.instagram.com/v1/users/self/?access_token=';

							var instagramUserServiceFactory = {
								getUserInfo : getUserInfo
							};

							return instagramUserServiceFactory;

							function getUserInfo(token, callback, error) {
								var urlTo = apiURL + token + '&callback=JSON_CALLBACK';
										
								$sce.trustAsResourceUrl(urlTo);

								$http.jsonp(urlTo, {
									method : 'GET'
								}).then(function(response) {
									callback(response.data);
								}, error);
							}

						} ]);