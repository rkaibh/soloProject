var app = angular.module("ItemManag", []);

app.controller("itemManag", function($scope, $rootScope, $http, $location, $filter){
	
	var items = "";
	$scope.items = [];
	
	$scope.itemList = () => {
		
		if($rootScope.loginUser != null){
			$http.post("itemManage", "", {params: $rootScope.loginUser}).then(function(result){
				if(result.data.list.length == 0){
					
						$http.post("forCreate", "", {params: $rootScope.loginUser}).then(function(result){
							
							for(var i=0; i<result.data.list.length; i++){
								if(result.data.list[i].authority == "ROLE_USER"){
									result.data.list[i]["user_ID"] = $rootScope.loginUser.user_ID;
									
									$http.post("addItem", "", {params: result.data.list[i]}).then(function(result){
									}), function(result){
									};
								}
							}
							alert("저장되있는 본사의 데이터를 불러옵니다.");
							location.reload();
						}), function(result){
						};
				
				} else {
					$scope.items = result.data.list;
					
					var items = result.data.list;
					$rootScope.filter = (filterObj) => {
						$scope.items = $filter('filter')(items, filterObj);
				    };
				}
			}), function(result){
			};
		} else {
			console.log("로그인 정보가 없습니다.");
		}
	};
	
	$scope.addItem = () => {
		$location.path('/itemCreate');
	};
	
	$scope.ItemCreate = () => {
		if($scope.item == null){
			
		} else {
			$http.post("addItem", "", {params: $scope.item}).then(function(result){
				$rootScope.toItemManag();
			}), function(result){
			};
		}
	};
	
	$scope.initTem = () => {
		if($rootScope.loginUser == null){
			console.log("로그인 정보가 없습니다.");
		} else{
			$scope.item = {
				item_Name: "",
				item_Price: "",
				item_Category: "",
				item_Cost: "",
				user_ID: $rootScope.loginUser.user_ID,
				company: $rootScope.loginUser.company
			};
		}
	};
	
	$scope.itemList();
	$scope.initTem();
	
});