var app = angular.module("StartPos", []);

app.controller("startPos", function($rootScope, $scope, $http){
	
	$rootScope.orderList = [];
	$scope.numLimit = [{},{},{},{},{}];
	
	$rootScope.colbox = [
		{Table:[
			{
					Name: "T-1"
			},
			{
					Name: "T-2"
			},
			{
					Name: "T-3"
			}
		]},
		{Table:[
			{
					Name: "T-4"
			},
			{
					Name: "T-5"
			},
			{
					Name: "T-6"
			}
		]},
		{Table:[
			{
					Name: "T-7"
			},
			{
					Name: "T-8"
			},
			{
					Name: "T-9"
			}
		]},
		{Table:[
			{
					Name: "T-10"
			},
			{
					Name: "T-11"
			},
			{
					Name: "T-12"
			}
		]},
		{Table:[
			{
					Name: "포장-1"
			},
			{
					Name: "포장-2"
			},
			{
					Name: "포장-3"
			}
		]},
		{Table:[
			{
					Name: "에약-1"
			},
			{
					Name: "예약-2"
			},
			{
					Name: "예약-3"
			}
		]}
	];
	
	$rootScope.find = () => {
		$rootScope.itemIndex = [];
		
		$http.post("orderDetailList", "", {params:$rootScope.loginUser}).then(function(result){
			if(result.data.list == null){
				console.log("로그인 되지 않았습니다.");
			}
			$rootScope.itemIndex = result.data.list;
		}),function(result){
		};
	};
	
	setTimeout(function() {
		$rootScope.find()
		}, 1300);
	
});