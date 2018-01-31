var app = angular.module("Adduser", []);

app.controller("adduser", function($scope, $rootScope, $http, $location){
	
	$scope.user = {
			user_ID: "",
			user_PW: "",
			user_Name: "",
			address: "",
			fund:"",
			company: ""
	};
	
	$scope.Not = true;
	
	$scope.userAdd = () =>{
		
		$scope.user["company"] = $rootScope.loginUser.company;
		
		$http.post("addUser","", {params:$scope.user}).then(function(result){
			if(result.data.stat == 1){
				$rootScope.toManagement();
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
				$scope.Not = false;
			} else {
				$scope.Not = true;
			}
			
			}), function(result){
			};
	}
	
});
