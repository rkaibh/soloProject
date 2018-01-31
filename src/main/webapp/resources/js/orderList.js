var app = angular.module("OrderList", []);

app.controller("orderList", function($rootScope, $scope, $http){
	
	$scope.List = () =>{
		$http.post("forOrderList", "", {params:$rootScope.loginUser}).then(function(result){
			for(var i=0; i<result.data.list.length; i++){
				result.data.list[i]["index"] = i + 1;
			}
			$scope.ListOrder = result.data.list;
			$scope.LookDetail(result.data.list[0]); 
		}), function(result){
		};
	};
	
	$scope.LookDetail = (param) => {
		if(param == undefined){
			console.log("주문 내역이 없습니다.");
		} else {
			$http.post("forOrderDetail", "", {params: param}).then(function(result){
				if(result.data.stat == 0){
					$scope.detail = {
							order_No: param.index,
							order_Way: result.data.order_Way,
							reg_date: result.data.reg_date
					};
				} else {
					$scope.detailList = result.data.list;
					$scope.detail = {
							order_No: param.index,
							order_Way: result.data.order_Way,
							reg_date: result.data.reg_date
					};
				}
				}), function(result){
				};
		}
	};
	
	setTimeout(function() {
		$scope.List()
		}, 1300);
	
});