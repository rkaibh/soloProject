var app = angular.module("Pos", []);

app.controller("pos", function($scope, $rootScope, $http, $location){
	
	$scope.boarding = [];
	
	$scope.boardfirst = () => {
		$http.post("first", "", {params: $rootScope.loginUser}).then(function(result){
		}), function(result){
		};
		$scope.boardlist();
	};
	
	$scope.boardlist = () => {
		if($rootScope.loginUser != null){
			$http.post("boardList", "", {params: $rootScope.loginUser}).then(function(result){
				if(result.data.list.length == 0){
					if($rootScope.onchk){
						if($rootScope.loginchk){
							$scope.boardfirst();
						} else {
							$scope.boarding = result.data.list;
						}
					} else {
						$rootScope.toLogin();
					}
				}else {
					$scope.boarding = result.data.list;
				}
			}), function(result){
				console.log(result);
			};
		} else{
		}
	};
	
	$rootScope.toRead = (param) => {
		
		$rootScope.toparam = {
				no:"",
				company:"",
		}
		$rootScope.toparam=param;
		
		$http.post("boardDetail", "", {params: $rootScope.toparam}).then(function(result){
			$rootScope.detailBoard = result.data;
		}), function(result){
		};
		$location.path('/read');
	};
	
	$rootScope.keepUser();
	
	setTimeout(function() {
		$scope.boardlist()
		}, 1300);
	
});