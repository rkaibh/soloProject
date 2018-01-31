var app = angular.module("Login", []);

app.controller("login", function($rootScope, $scope, $http, $location, $filter){
	
	$rootScope.loginUser = [];
	
	$scope.user = {
			user_ID:"",
			user_PW:""
	};
	
	$scope.Not = true;
	
	$scope.login = () => {
	
		$http.post("logon", "", {params: $scope.user}).then(function(result){
			if(result.data.search == 0){
				$scope.Not = false;
			} else {
				$rootScope.loginUser = result.data.logonUser;
					$rootScope.toPos();
			}
		}), function(result){
		};
	};
	
});