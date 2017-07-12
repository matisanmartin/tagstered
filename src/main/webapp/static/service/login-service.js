'use strict';

angular.module('tagstered').factory('LoginService',
		[ '$http', '$q', function($http, $q) {

			var factory = {
				redirectToUser : redirectToUser
			};
			
			function redirectToUser() {
				return 1;
			};

			return factory;

		} ]);