'use strict';

angular
		.module('tagstered')
		.controller(
				'LoginController',
				[
						'$scope',
						'$location',
						'LoginService',
						function($scope, $location, LoginService) {

							$scope.tags = [ {
								tagName : "igersBsas"
							}, {
								tagName : "aGameOfTones"
							} ];

							$scope.recentTags = {
								"pagination" : {
									"next_min_id" : "AQDkPDsmQvxbbF32UJJOHRwENdEgMp1toMvzGtNB5GPC8BSIG0jV35J43Q8gkpDzBKfGgBKHvmeCDyl1xMQgotrDzoYoR0STOBvd3GiNNVRPtw",
									"min_tag_id" : "AQDkPDsmQvxbbF32UJJOHRwENdEgMp1toMvzGtNB5GPC8BSIG0jV35J43Q8gkpDzBKfGgBKHvmeCDyl1xMQgotrDzoYoR0STOBvd3GiNNVRPtw",
									"deprecation_warning" : "next_max_id and min_id are deprecated for this endpoint; use min_tag_id and max_tag_id instead"
								},
								"data" : [
										{
											"id" : "1545169645907279150_1010641789",
											"user" : {
												"id" : "1010641789",
												"full_name" : "Matias San Martin Acosta",
												"profile_picture" : "https://scontent.cdninstagram.com/t51.2885-19/s150x150/17934581_1922412948043509_3925049064239923200_a.jpg",
												"username" : "matism"
											},
											"images" : {
												"thumbnail" : {
													"width" : 150,
													"height" : 150,
													"url" : "https://scontent.cdninstagram.com/t51.2885-15/s150x150/e35/19436373_289423448195531_7055844390664667136_n.jpg"
												},
												"low_resolution" : {
													"width" : 320,
													"height" : 320,
													"url" : "https://scontent.cdninstagram.com/t51.2885-15/s320x320/e35/19436373_289423448195531_7055844390664667136_n.jpg"
												},
												"standard_resolution" : {
													"width" : 640,
													"height" : 640,
													"url" : "https://scontent.cdninstagram.com/t51.2885-15/s640x640/sh0.08/e35/19436373_289423448195531_7055844390664667136_n.jpg"
												}
											},
											"created_time" : "1498418597",
											"caption" : {
												"id" : "17886287272029492",
												"text" : "Through the clouds we arrive",
												"created_time" : "1498418597",
												"from" : {
													"id" : "1010641789",
													"full_name" : "Matias San Martin Acosta",
													"profile_picture" : "https://scontent.cdninstagram.com/t51.2885-19/s150x150/17934581_1922412948043509_3925049064239923200_a.jpg",
													"username" : "matism"
												}
											},
											"user_has_liked" : false,
											"likes" : {
												"count" : 99
											},
											"tags" : [ "ig_argentina",
													"instagrames",
													"collectivelycreate",
													"peoplecreatives",
													"fatalframes",
													"moodygrams",
													"artofvisuals",
													"thecreatorclass",
													"nikonphoto", "huntgram",
													"heatercentral",
													"agameoftones", "nikon_ar",
													"nikontop", "igersbsas",
													"hallazgosemanal",
													"way2ill", "createexplore",
													"visualsoflife",
													"shoot2kill", "instagram",
													"nikon", "ig_buenosaires" ],
											"filter" : "Normal",
											"comments" : {
												"count" : 2
											},
											"type" : "image",
											"link" : "https://www.instagram.com/p/BVxi5s2BP0u/",
											"location" : null,
											"attribution" : null,
											"users_in_photo" : [

											]
										},
										{
											"id" : "1509487623197422247_1010641789",
											"user" : {
												"id" : "1010641789",
												"full_name" : "Matias San Martin Acosta",
												"profile_picture" : "https://scontent.cdninstagram.com/t51.2885-19/s150x150/17934581_1922412948043509_3925049064239923200_a.jpg",
												"username" : "matism"
											},
											"images" : {
												"thumbnail" : {
													"width" : 150,
													"height" : 150,
													"url" : "https://scontent.cdninstagram.com/t51.2885-15/s150x150/e35/18299474_167606917101200_7066894937790349312_n.jpg"
												},
												"low_resolution" : {
													"width" : 320,
													"height" : 320,
													"url" : "https://scontent.cdninstagram.com/t51.2885-15/s320x320/e35/18299474_167606917101200_7066894937790349312_n.jpg"
												},
												"standard_resolution" : {
													"width" : 640,
													"height" : 640,
													"url" : "https://scontent.cdninstagram.com/t51.2885-15/s640x640/sh0.08/e35/18299474_167606917101200_7066894937790349312_n.jpg"
												}
											},
											"created_time" : "1494164968",
											"caption" : {
												"id" : "17855591890160846",
												"text" : "Sunday comes and sunday goes",
												"created_time" : "1494164968",
												"from" : {
													"id" : "1010641789",
													"full_name" : "Matias San Martin Acosta",
													"profile_picture" : "https://scontent.cdninstagram.com/t51.2885-19/s150x150/17934581_1922412948043509_3925049064239923200_a.jpg",
													"username" : "matism"
												}
											},
											"user_has_liked" : false,
											"likes" : {
												"count" : 107
											},
											"tags" : [ "nikon_photography",
													"nikon_ar", "nikon",
													"nikontop", "d5200",
													"igersbsas" ],
											"filter" : "Normal",
											"comments" : {
												"count" : 1
											},
											"type" : "image",
											"link" : "https://www.instagram.com/p/BTyxv7lh_Kn/",
											"location" : null,
											"attribution" : null,
											"users_in_photo" : [

											]
										},
										{
											"id" : "1504750814579945858_1010641789",
											"user" : {
												"id" : "1010641789",
												"full_name" : "Matias San Martin Acosta",
												"profile_picture" : "https://scontent.cdninstagram.com/t51.2885-19/s150x150/17934581_1922412948043509_3925049064239923200_a.jpg",
												"username" : "matism"
											},
											"images" : {
												"thumbnail" : {
													"width" : 150,
													"height" : 150,
													"url" : "https://scontent.cdninstagram.com/t51.2885-15/s150x150/e35/18251691_1941442489206516_2850096862621335552_n.jpg"
												},
												"low_resolution" : {
													"width" : 320,
													"height" : 320,
													"url" : "https://scontent.cdninstagram.com/t51.2885-15/s320x320/e35/18251691_1941442489206516_2850096862621335552_n.jpg"
												},
												"standard_resolution" : {
													"width" : 640,
													"height" : 640,
													"url" : "https://scontent.cdninstagram.com/t51.2885-15/s640x640/sh0.08/e35/18251691_1941442489206516_2850096862621335552_n.jpg"
												}
											},
											"created_time" : "1493600297",
											"caption" : {
												"id" : "17870425903077022",
												"text" : "Mejor quedarse quieto y esperar",
												"created_time" : "1493600297",
												"from" : {
													"id" : "1010641789",
													"full_name" : "Matias San Martin Acosta",
													"profile_picture" : "https://scontent.cdninstagram.com/t51.2885-19/s150x150/17934581_1922412948043509_3925049064239923200_a.jpg",
													"username" : "matism"
												}
											},
											"user_has_liked" : false,
											"likes" : {
												"count" : 76
											},
											"tags" : [ "nikon_photography",
													"nikon_ar", "nikon",
													"nikontop", "d5200",
													"igersbsas" ],
											"filter" : "Normal",
											"comments" : {
												"count" : 4
											},
											"type" : "image",
											"link" : "https://www.instagram.com/p/BTh8uSyhHGC/",
											"location" : null,
											"attribution" : null,
											"users_in_photo" : [

											]
										},
										{
											"id" : "1393710848954671126_1010641789",
											"user" : {
												"id" : "1010641789",
												"full_name" : "Matias San Martin Acosta",
												"profile_picture" : "https://scontent.cdninstagram.com/t51.2885-19/s150x150/17934581_1922412948043509_3925049064239923200_a.jpg",
												"username" : "matism"
											},
											"images" : {
												"thumbnail" : {
													"width" : 150,
													"height" : 150,
													"url" : "https://scontent.cdninstagram.com/t51.2885-15/s150x150/e35/c180.0.720.720/14723013_1296004713784045_4771580525506723840_n.jpg"
												},
												"low_resolution" : {
													"width" : 320,
													"height" : 213,
													"url" : "https://scontent.cdninstagram.com/t51.2885-15/s320x320/e35/14723013_1296004713784045_4771580525506723840_n.jpg"
												},
												"standard_resolution" : {
													"width" : 640,
													"height" : 426,
													"url" : "https://scontent.cdninstagram.com/t51.2885-15/s640x640/sh0.08/e35/14723013_1296004713784045_4771580525506723840_n.jpg"
												}
											},
											"created_time" : "1480363301",
											"caption" : {
												"id" : "17857665787078202",
												"text" : "El manantial brot\u00f3 y nadie est\u00e1 aqu\u00ed",
												"created_time" : "1480363301",
												"from" : {
													"id" : "1010641789",
													"full_name" : "Matias San Martin Acosta",
													"profile_picture" : "https://scontent.cdninstagram.com/t51.2885-19/s150x150/17934581_1922412948043509_3925049064239923200_a.jpg",
													"username" : "matism"
												}
											},
											"user_has_liked" : false,
											"likes" : {
												"count" : 78
											},
											"tags" : [ "igersbsas" ],
											"filter" : "Normal",
											"comments" : {
												"count" : 1
											},
											"type" : "image",
											"link" : "https://www.instagram.com/p/BNXdKIHjSAW/",
											"location" : null,
											"attribution" : null,
											"users_in_photo" : [

											]
										},
										{
											"id" : "1344625310377451683_1010641789",
											"user" : {
												"id" : "1010641789",
												"full_name" : "Matias San Martin Acosta",
												"profile_picture" : "https://scontent.cdninstagram.com/t51.2885-19/s150x150/17934581_1922412948043509_3925049064239923200_a.jpg",
												"username" : "matism"
											},
											"images" : {
												"thumbnail" : {
													"width" : 150,
													"height" : 150,
													"url" : "https://scontent.cdninstagram.com/t51.2885-15/s150x150/e35/c180.0.720.720/14310668_1685960521723157_1996190646154559488_n.jpg"
												},
												"low_resolution" : {
													"width" : 320,
													"height" : 213,
													"url" : "https://scontent.cdninstagram.com/t51.2885-15/s320x320/e35/14310668_1685960521723157_1996190646154559488_n.jpg"
												},
												"standard_resolution" : {
													"width" : 640,
													"height" : 426,
													"url" : "https://scontent.cdninstagram.com/t51.2885-15/s640x640/sh0.08/e35/14310668_1685960521723157_1996190646154559488_n.jpg"
												}
											},
											"created_time" : "1474511849",
											"caption" : {
												"id" : "17853922312079347",
												"text" : "Es peligrosa, te har\u00e1 mortal",
												"created_time" : "1474511849",
												"from" : {
													"id" : "1010641789",
													"full_name" : "Matias San Martin Acosta",
													"profile_picture" : "https://scontent.cdninstagram.com/t51.2885-19/s150x150/17934581_1922412948043509_3925049064239923200_a.jpg",
													"username" : "matism"
												}
											},
											"user_has_liked" : false,
											"likes" : {
												"count" : 145
											},
											"tags" : [

											],
											"filter" : "Normal",
											"comments" : {
												"count" : 6
											},
											"type" : "image",
											"link" : "https://www.instagram.com/p/BKpEZh9DCCj/",
											"location" : null,
											"attribution" : null,
											"users_in_photo" : [

											]
										} ],
								"meta" : {
									"code" : 200
								}
							};

							$scope.images = $scope.recentTags.data;

							$scope.addNewTag = function(newTag) {
								$scope.tags.push({
									tagName : newTag
								});
							};

							$scope.loadMore = function(next_min_id) {
								$scope.newImages = [ {
									"id" : "1334399328689471796_1010641789",
									"user" : {
										"id" : "1010641789",
										"full_name" : "Matias San Martin Acosta",
										"profile_picture" : "https://scontent.cdninstagram.com/t51.2885-19/s150x150/17934581_1922412948043509_3925049064239923200_a.jpg",
										"username" : "matism"
									},
									"images" : {
										"thumbnail" : {
											"width" : 150,
											"height" : 150,
											"url" : "https://scontent.cdninstagram.com/t51.2885-15/s150x150/e35/c180.0.720.720/14272179_1099956680041072_1982796082_n.jpg"
										},
										"low_resolution" : {
											"width" : 320,
											"height" : 213,
											"url" : "https://scontent.cdninstagram.com/t51.2885-15/s320x320/e35/14272179_1099956680041072_1982796082_n.jpg"
										},
										"standard_resolution" : {
											"width" : 640,
											"height" : 426,
											"url" : "https://scontent.cdninstagram.com/t51.2885-15/s640x640/sh0.08/e35/14272179_1099956680041072_1982796082_n.jpg"
										}
									},
									"created_time" : "1473292817",
									"caption" : {
										"id" : "17851676233086521",
										"text" : "Desperdigados por fantasias",
										"created_time" : "1473292817",
										"from" : {
											"id" : "1010641789",
											"full_name" : "Matias San Martin Acosta",
											"profile_picture" : "https://scontent.cdninstagram.com/t51.2885-19/s150x150/17934581_1922412948043509_3925049064239923200_a.jpg",
											"username" : "matism"
										}
									},
									"user_has_liked" : true,
									"likes" : {
										"count" : 120
									},
									"tags" : [ "photostreet",
											"streetdreamsmag", "goexplore",
											"city_explore", "instagrames",
											"urbanphotography", "citykillerz",
											"streetmobs", "fatalframes",
											"artofvisuals", "huntgram",
											"agameoftones", "nikon_ar",
											"nikontop", "jointheclass",
											"exploretocreate", "beststreets",
											"igersbsas", "nikon_photography",
											"createexplore", "nikond5200",
											"createexploretakeover",
											"ink361_southamerica",
											"shoot2kill", "ink361",
											"communityfirst",
											"visualsofstreet", "nikon",
											"urbanstreet" ],
									"filter" : "Normal",
									"comments" : {
										"count" : 4
									},
									"type" : "image",
									"link" : "https://www.instagram.com/p/BKEvR6XDkE0/",
									"location" : null,
									"attribution" : null,
									"users_in_photo" : [ {
										"user" : {
											"id" : "1116619703",
											"full_name" : "Euge Assalone",
											"profile_picture" : "https://scontent.cdninstagram.com/t51.2885-19/s150x150/18444181_738444206338240_2015949647494774784_a.jpg",
											"username" : "cacsalone"
										},
										"position" : {
											"x" : 0.26597223,
											"y" : 0.31041667
										}
									} ]
								} ];

								if ($scope.newImages.length > 0)
									$scope.images = $scope.images.concat($scope.newImages);
							}
						} ]);
