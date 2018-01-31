var app = angular.module("Sales", []);

app.controller("sales", function($rootScope, $scope, $http){

	$scope.itemchk = true;
	
	setTimeout(function() {
		$scope.dateFunc()
		}, 1300);
		
	
	$scope.dateFunc = () => {
		if($rootScope.loginUser != null){
			$http.post("daySert", "", {params:$rootScope.loginUser}).then(function(result){
				$scope.fund = $rootScope.loginUser.fund;
				$scope.sert = {
						daySert: result.data.daySert.tot,
						weekSert: result.data.weekSert.tot,
						monthSert: result.data.monthSert.tot
				};
				if($scope.sert.daySert == null){
					$scope.sert.daySert = result.data.daySert;
				}
				if($scope.sert.weekSert == null){
					$scope.sert.weekSert = result.data.weekSert;
				}
				if($scope.sert.monthSert == null){
					$scope.sert.monthSert = result.data.monthSert;
				}
			}), function(result){
			};
			
		} else {
			console.log("로그인 정보가 없음");
		}
	}
	
	$scope.toItemSearch = (param) => {
		
		if(param == null){
			$scope.itemchk = false;
		}
		$scope.temSearch = {
				item_Name: param,
				user_ID: $rootScope.loginUser.user_ID
		};
		$http.post("itemSearch", "", {params: $scope.temSearch}).then(function(result){
			$scope.itemchk = true;
			if(result.data.stat == 1){
				$http.post("itemSert", "", {params: result.data.item_Name}).then(function(result){
					$scope.itemSert = {
							item_Name: $scope.temSearch.item_Name,
							daySert: result.data.itemDaySert.tot,
							dayAmount: result.data.itemDaySert.res,
							weekSert: result.data.itemWeekSert.tot,
							weekAmount: result.data.itemWeekSert.res,
							monthSert: result.data.itemMonthSert.tot,
							monthAmount: result.data.itemMonthSert.res
					};
					if(result.data.itemDaySert.tot == undefined){
						$scope.itemSert.daySert = result.data.itemDaySert;
						$scope.itemSert.dayAmount = result.data.itemDaySert;
					}
					if(result.data.itemWeekSert.tot == undefined){
						$scope.itemSert.weekSert = result.data.itemWeekSert;
						$scope.itemSert.weekAmount = result.data.itemWeekSert;
					}
					if(result.data.itemMonthSert.tot == undefined){
						$scope.itemSert.monthSert = result.data.itemMonthSert;
						$scope.itemSert.monthAmount = result.data.itemMonthSert;
					}
				}), function(result){
				};
			} else if(result.data.stat == 0){
				$scope.itemchk = false;
			}
			
		}), function(result){
		};
	}
	
});