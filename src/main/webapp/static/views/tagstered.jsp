<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tagstered</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular-resource.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular-route.js"></script>
</head>
<body ng-app="tagstered" ng-controller="TagsteredController"
	scroll="loadMore(recentTags.next_min_id)">

	<div class="container">
		<h1>
			<strong>Tagstered</strong>
		</h1>

		<div class="row" style="height: 10px"></div>

		<div ng-show="showLogin" class="text-center">
			<button class="btn btn-primary" ng-click="login()">Log in
				with Instagram</button>
		</div>

		<div ng-show="!showLogin">
			<div class="row">
				<div class="col-xs-4 col-md-4 col-lg-4">

					<input name="newTag" type="text" class="form-group"
						data-ng-model="newTag" placeholder="Search Tag" />
					<button class="btn btn-primary" ng-click="addNewTag(newTag)">Follow!</button>
					<table class="table table-striped">
						<thead>
							<tr>
								<th class="info">Followed tags</th>
								<th class="info"></th>
								<th class="info"></th>
							</tr>
						</thead>
						<tbody>
							<tr ng-repeat="t in tags">
								<td>{{t.tagName}}</td>
								<td><button class="btn btn-success"
										ng-click="showTagRecentMedia(t.tagName)">Show recent</button></td>
								<td><button class="btn btn-danger"
										ng-click="removeTag(t.tagName)">Remove</button>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="col-xs-8 col-md-8 col-lg-8">
					<div ng-repeat="i in images">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<span> <img ng-src="{{i.user.profile_picture}}"
									class="img-circle" width="30" height="30">
								</span> <span><strong>{{i.user.username}}</strong></span>
							</div>
							<div class="panel-body text-center">
								<div class="row">
									<img ng-src="{{i.images.standard_resolution.url}}">
								</div>
								<div class="row">
									<span>Likes: {{i.likes.count}}</span>
								</div>
								<div class="row">
									<span> <a href="{{i.link}}">{{i.link}}</a>
									</span>
								</div>
							</div>
							<div class="panel-footer">
								<div class="row" style="overflow-wrap: break-word;">
									<em>Image Tags:</em> {{i.tags.join(', ')}}
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="${pageContext.request.contextPath}/static/app.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/controller/tagstered-controller.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/service/user-service.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/service/instagram-tag-service.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/service/instagram-auth-service.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/directive/scroll.js"></script>
</body>
</html>