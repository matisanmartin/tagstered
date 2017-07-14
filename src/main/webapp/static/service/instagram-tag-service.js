'use strict';

angular
		.module('tagstered')
		.factory(
				'InstagramTagService',
				[
						'$http',
						'$sce',
						function($http, $sce) {

							var apiURL = 'https://api.instagram.com/v1/tags/';
							var recentMediaURL = '/media/recent?access_token='
							//var accessToken = '1010641789.6e0b393.bf7d3f8e549844db81b1e43a0a9484ae';
							var nextMaxIdURL = '&next_max_id=';

							var instagramTagServiceFactory = {
								getRecentTagMedia : getRecentTagMedia
							};

							return instagramTagServiceFactory;

							function getRecentTagMedia(tag, nextMaxId, token, callback, error) {
								var urlTo = apiURL + tag + recentMediaURL + token + '&callback=JSON_CALLBACK';
										
								if (nextMaxId) {
									urlTo += nextMaxIdURL;
								}
								
								$sce.trustAsResourceUrl(urlTo);

								$http.jsonp(urlTo, {
									method : 'GET'
								}).then(function(response) {
									callback(response.data);
								}, error);
							}

						} ]);