'use strict';

var app = angular.module('tagstered', [ 'ngResource', 'ngRoute', ]).config(
		[ '$routeProvider', '$locationProvider',
				function($routeProvider, $locationProvider) {

					$locationProvider.hashPrefix('');
					$locationProvider.html5Mode({
						enabled : true,
						requireBase : false
					});

				} ]);
