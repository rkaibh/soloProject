var app = angular.module("Management", []);

app.controller("management", function($scope, $rootScope, $http, $location){
	
	$rootScope.userList();

	$rootScope.userDel = (param) => {
		$http.post("userDel", "", {params: param}).then(function(result){
			$rootScope.userList();
		}), function(result){
		};
	};
	
	$scope.addUser = () => {
		$location.path('/adduser');
	};
	
});
