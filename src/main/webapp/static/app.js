'use strict';

var app = angular.module('tagstered', [ 'ngResource', 'ngRoute', ]).config(
		[ '$routeProvider', '$locationProvider',
				function($routeProvider, $locationProvider) {

					$locationProvider.hashPrefix('');
					$locationProvider.html5Mode({
						enabled : true,
						requireBase : false
					});

					$routeProvider.when('/', {
						templateUrl : 'views/login.jsp',
						controller : 'LoginController'
					}).when('/user/:id', {
						templateUrl : 'views/user.jsp',
						controller : 'UserController.html'
					}).when('/home/:id', {
						templateUrl : 'views/home.jsp',
						controller : 'HomeController'
					}).when('/tag/:id', {
						templateUrl : 'views/tag.jsp',
						controller : 'TagController'
					}).otherwise({
						redirectTo : '/'
					});

				} ]);
