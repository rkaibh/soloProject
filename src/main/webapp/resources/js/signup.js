var app = angular.module("SignUp", []);

app.controller("signup", function($rootScope, $scope, $location, $http){
	
	$rootScope.admin = {
			user_ID:"",
			user_PW:"",
			user_Name:"",
			company:"",
			fund:"",
			address:"",
	};
	
	$scope.Not = false;
	$scope.Or = false;
	$scope.addAdmin = () => {
		$http.post("addAdmin","", {params:$rootScope.admin}).then(function(result){
			if(result.data.stat == 1){
				$rootScope.toLogin();
			}else{
				location.reload();
			}
			}), function(result){
			};
	};
	
	$scope.toChk = (param) => {
		$scope.imcy = {
				user_ID: param
		};
		$http.post("IDList", "", {params: $scope.imcy}).then(function(result){
			if(result.data.search == null){
				$scope.Not = true;
				$scope.Or = true;
			} else {
				$scope.Not = false;
				$scope.Or = false;
			}
			
			}), function(result){
			};
	};
});