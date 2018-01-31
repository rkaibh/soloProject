var app = angular.module("SellList", []);

app.controller("sellList", function($rootScope, $scope, $http){
	
	$scope.sellList = () => {
		$http.post("sellList3", "", {params: $rootScope.loginUser}).then(function(result){
			$scope.Listsell = result.data.list;
			if($scope.Listsell.length == 0){
				console.log("판매내역이 없습니다.");
			} else {
				$scope.orderNum = $scope.Listsell[0];
				$scope.listsell($scope.Listsell[0]);
				if($scope.orderNum == null){
					$scope.orderNum = {order_No:""};
				}
			}
			
		}), function(result){
		};
	};
	
	$scope.foritem = (param) => {
		$scope.orderNum = param;
		$scope.listsell($scope.orderNum);
	};
	
	$scope.listsell = (param) => {
		$http.post("sellforList", "", {params: param}).then(function(result){
			$scope.fortemList = result.data.list;
			$scope.orderNum["order_No"] = $scope.fortemList[0].order_No;
			$scope.orderNum["order_Way"] = $scope.fortemList[0].order_Way;
			$scope.orderNum["reg_date"] = param.reg_date;
			if($scope.fortemList != null){
				for(var i=0; i<$scope.fortemList.length; i++){
					$scope.fortemList[i]["item_Piece"] = $scope.fortemList[i].item_Price / $scope.fortemList[i].item_Amount;
				}
			}
		}), function(result){
		};
	};
	
	
	setTimeout(function() {
		$scope.sellList()
		}, 1300);
	
});