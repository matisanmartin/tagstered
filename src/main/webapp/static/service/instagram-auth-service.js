'use strict';

angular
		.module('tagstered')
		.factory(
				'InstagramAuthService',
				[
						'$http',
						'$sce',
						'$window',
						function($http, $sce, $window) {

							var apiURL = '/tagstered/auth/';

							return {
								getClientId : getClientId,
								getUserByAccessToken : getUserByAccessToken,
								login : login
							};

							function getClientId(success, error) {
								$http({
									method : 'GET',
									url : apiURL + '/clientId',
									headers : {
										'Content-Type' : 'application/json'
									}
								}).then(success, error);
							}

							function getUserByAccessToken(token, callback,
									error) {

								var urlTo = 'https://api.instagram.com/v1/users/self/?access_token='
										+ token + '&callback=JSON_CALLBACK';

								$sce.trustAsResourceUrl(urlTo);

								$http.jsonp(urlTo, {
									method : 'GET'
								}).then(function(response) {
									callback(response.data);
								}, error);
							}

							function login(success, error) {
								$http({
									method : 'GET',
									url : apiURL + '/loginUrl',
									headers : {
										'Content-Type' : 'application/json'
									}
								}).then(function(response) {
									$window.location.href = response.data.value;
								}, error)
							}

						} ]);