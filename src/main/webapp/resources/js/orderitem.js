var app = angular.module("OrderItem", []);

app.controller("orderitem", function($rootScope, $http, $scope, $filter){
	
	$scope.items = [];
	$rootScope.selecteditems = [];
	
	$scope.itemList = () => {
		$http.post("itemList", "", {params: $rootScope.loginUser}).then(function(result){
			$scope.items = result.data.list;
			
			var items = result.data.list;
			$rootScope.filter = (filterObj) => {
				$scope.items = $filter('filter')(items, filterObj);
		    };
		    
		}), function(result){
		};
	}
	
	$scope.reservItem = (param) => {
		$rootScope.selectitem = param;
	};
	
	$scope.btn1 = () => {
		$rootScope.reservItem = {
				item_No: $rootScope.selectitem.item_No,
				item_Name: $rootScope.selectitem.item_Name,
				item_Cost: $rootScope.selectitem.item_Cost,
				user_ID: $rootScope.loginUser.user_ID,
				reserv_Amount: ""
		};
		$("#myModal").modal("show");
	};
	
	$scope.btn2 = () => {
		for(var i = 0; i < $rootScope.selecteditems.length; i++){
			if($scope.selectitem.item_Name == $rootScope.selecteditems[i].item_Name){
				$rootScope.selecteditems.splice(i, 1);
			}
		}
	};
	    
	$rootScope.itemReserve = (param) => {
		$scope.selecteditem = param;
		if($rootScope.selecteditems.length == 0){
			$rootScope.selecteditems.push($scope.selecteditem);
		} else {
			var flag = true;
			
			for(var i = 0; i < $rootScope.selecteditems.length; i++){
				if($scope.selecteditem.item_Name == $rootScope.selecteditems[i].item_Name){
					$rootScope.selecteditems.splice(i, 1, {
							item_No: $rootScope.selecteditems[i].item_No,
							item_Name: $rootScope.selecteditems[i].item_Name,
							reserv_Amount: parseInt($rootScope.selecteditems[i].reserv_Amount) + parseInt($rootScope.reservItem.reserv_Amount)
					});
					flag = false;
					break;
				}
			}
			
			if(flag) {
				$rootScope.selecteditems.push($scope.selecteditem);
			}
		}
		$("#myModal").modal("hide");
	};
	
	$scope.reservList = () => {
		$http.post("reservList", "", {params: $rootScope.loginUser}).then(function(result){
			$scope.reservlist = result.data.list;
		}), function(result){
		};
	};
	
	$scope.btn3 = () => {
		$http.post("reservItem", "", {params: $rootScope.selectitem}).then(function(result){
			$scope.reservList();
		}), function(result){
		};
		$rootScope.selecteditems.splice($rootScope.selectitem, 1);
	};
	
	setTimeout(function() {
		$scope.itemList()
		$scope.reservList()
		}, 1300);
	
});