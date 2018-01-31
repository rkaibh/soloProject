var app = angular.module("Write", []);

app.controller("write", function($scope, $rootScope, $http){
	
	$scope.board = {
			title:"",
			contents:"",
			company: ""
	};
	
	$rootScope.adminWrite = () => {
		
		$scope.board.company = $rootScope.loginUser.company;
		
		$http.post("adminAdd", "", {params: $scope.board}).then(function(result){
		}), function(result){
		};
		
		$rootScope.toPos();
	};
	
});