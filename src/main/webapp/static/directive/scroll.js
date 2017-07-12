'use strict';

angular.module('tagstered').directive('scroll', function($window) {
	return {
		restrict : 'A',
		link : function(scope, element, attrs) {
			angular.element($window).bind('scroll', function() {
				var windowHeight = "innerHeight" in window ? window.innerHeight : document.documentElement.offsetHeight;
				var body = document.body;
				var html = document.documentElement;
				var docHeight = Math.max(body.scrollHeight, body.offsetHeight, html.clientHeight, html.scrollHeight, html.offsetHeight);
				var windowBottom = windowHeight + window.pageYOffset;
				if (windowBottom >= docHeight) 
					scope.$apply(attrs.scroll);
			});
		}
	};
});