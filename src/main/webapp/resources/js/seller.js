var app = angular.module("Seller", []);

app.controller("seller", function($rootScope, $scope, $http, $location){
	
	var index = 0;
	var itemindex = "";
	$scope.result = 0;
	$scope.calput = {
			result: ""
	};
	$rootScope.cardput = {
			result : ""
	};
	$rootScope.card = {
			name: ""
	};
	$rootScope.sellItem = {};
	var isNull = true;
	$scope.CateList = [];
	$scope.itemsinCate= {
			user_ID: "",
			item_Category:""
	};
	$rootScope.selectToOrder = [];
	$scope.calcul = [{No:"7"}, {No:"8"}, {No:"9"}, {No:"4"}, {No:"5"}, {No:"6"}, {No:"1"}, {No:"2"},
		{No:"3"}, {No:"0"}, {No:"00"}, {No:"000"}];
	$rootScope.modalcalcul = [{No:"7"}, {No:"8"}, {No:"9"}, {No:"4"}, {No:"5"}, {No:"6"}, {No:"1"}, {No:"2"},
		{No:"3"}, {No:"-"}, {No:"0"}, {No:"clear"}];
	
	$scope.categoryList = () => {
		
		$scope.howmuch();
		
		$http.post("cateList", "", {params: $rootScope.loginUser}).then(function(result){
			$scope.CateList = result.data.list;
			
			if($scope.CateList.length < 8){
				
				for(var i = $scope.CateList.length; i < 8; i++ ){
					$scope.CateList.push({item_Category: "비어있음"});
				}
			}
			
			$scope.itemsInCategory(index);
			
		}), function(result){
		};
	};
	
	$scope.itemsInCategory = (index) => {
		
		if($rootScope.loginUser == null){
			$rootScope.loginUser = {
				user_ID: "비로그인"
			};
		};
		
		$scope.itemsinCate = {
				user_ID: $rootScope.loginUser.user_ID,
				item_Category: $scope.CateList[index].item_Category,
		};
		
		$scope.itemincateGo();
		
	};
	
	$scope.itemincateGo = () =>{
		
		$scope.howmuch();
		
		$http.post("itemincate", "", {params:$scope.itemsinCate}).then(function(result){
			
			$scope.CateItems = result.data.list;
			
			for(var i = 0; i < $scope.CateItems.length; i++){
				$scope.CateItems[i]["item_Amount"] = 1;
				$scope.CateItems[i]["order_Way"] = $rootScope.TableName;
			}
			
			if($scope.CateItems.length < 15){
				for(var i = $scope.CateItems.length; i < 15; i++){
					$scope.CateItems.push({item_Name: "비어있음"});
				}
			}
			
		}), function(result){
		};
	};
	
	$scope.cateIndex = (param) => {
		index = param;
		$scope.categoryList();
	};
	
	$scope.ItemIndex = (data) => {
		
		$scope.howmuch();
		
		if(data.inven_Amount < 1){
			alert("재고가 없습니다.");
			return;
		}
		
		var newData = {
				item_No : data.item_No,
				item_Name: data.item_Name,
				item_Amount: data.item_Amount,
				item_Price: data.item_Price,
				order_Way: $rootScope.TableName,
				inven_Amount: data.inven_Amount,
				del_yn: "N"
			};
		if(newData.item_Name == "비어있음"){
			false;
		} else {
			if($rootScope.selectToOrder.length == 0){
				$rootScope.selectToOrder.push(newData);
				$scope.howmuch();
			} else {
				var flag = true;
				
				for(var i = 0; i < $rootScope.selectToOrder.length; i++){
					if(data.item_Name == $rootScope.selectToOrder[i].item_Name){
						if($rootScope.selectToOrder[i].inven_Amount > 0){
							$rootScope.selectToOrder.splice(i, 1, {
									item_No: $rootScope.selectToOrder[i].item_No,
									item_Name: $rootScope.selectToOrder[i].item_Name,
									order_No: $rootScope.selectToOrder[i].order_No,
									order_Way: $rootScope.TableName,
									item_Amount: $rootScope.selectToOrder[i].item_Amount + 1,
									inven_Amount: $rootScope.selectToOrder[i].inven_Amount - 1,
									item_Price: $rootScope.selectToOrder[i].item_Price + data.item_Price,
									del_yn: "N"
							});
						} else {
							alert("재고가 부족합니다.");
							return;
						}
						$scope.howmuch();
						flag = false;
						break;
					}
				}
				
				if(flag) {
					$rootScope.selectToOrder.push(newData);
				}
				
			}
		}
		$scope.howmuch();
	};
	
	$scope.orderList = (param) => {
		
		$http.post("chkItem", "", {params: param}).then(function(result){
			$scope.selectOrderTem = result.data;
		}), function(result){
		};
		
		$scope.orderListAdd = () => {
			for(var i = 0; i < $rootScope.selectToOrder.length; i++){
				if(param.item_Name == $rootScope.selectToOrder[i].item_Name){
					if($rootScope.selectToOrder[i].inven_Amount > 0){
						$rootScope.selectToOrder.splice(i, 1, {
								item_No: $rootScope.selectToOrder[i].item_No,
								item_Name: $rootScope.selectToOrder[i].item_Name,
								order_No: $rootScope.selectToOrder[i].order_No,
								order_Way: $rootScope.TableName,
								item_Amount: $rootScope.selectToOrder[i].item_Amount + 1,
								inven_Amount: $rootScope.selectToOrder[i].inven_Amount - 1,
								item_Price: $rootScope.selectToOrder[i].item_Price + $scope.selectOrderTem.item_Price,
								del_yn: "N"
						});
					} else {
						alert("재고가 없습니다.");
						return;
					}
					$scope.howmuch();
					break;
				}
			}
		};
		
		$scope.orderListSub = () => {
			var subFlag = true;
			for(var i = 0; i < $rootScope.selectToOrder.length; i++){
				if(param.item_Name == $rootScope.selectToOrder[i].item_Name){
					$rootScope.selectToOrder.splice(i, 1, {
							item_No: $rootScope.selectToOrder[i].item_No,
							item_Name: $rootScope.selectToOrder[i].item_Name,
							order_No: $rootScope.selectToOrder[i].order_No,
							order_Way: $rootScope.TableName,
							item_Amount: $rootScope.selectToOrder[i].item_Amount - 1,
							item_Price: $rootScope.selectToOrder[i].item_Price - $scope.selectOrderTem.item_Price,
							del_yn: "N"
					});
					if($rootScope.selectToOrder[i].item_Amount <= 0){
						subFlag = false;
						if(!subFlag){
							$rootScope.selectToOrder.splice(i, 1, {
								item_No: $rootScope.selectToOrder[i].item_No,
								item_Name: $rootScope.selectToOrder[i].item_Name,
								order_No: $rootScope.selectToOrder[i].order_No,
								order_Way: $rootScope.TableName,
								item_Amount: 0,
								item_Price: 0,
								del_yn: "Y"
							});
						}
					}
					$scope.howmuch();
					break;
				}
			}
		};
		
		$scope.orderListDel = () => {
			for(var i = 0; i < $rootScope.selectToOrder.length; i++){
				if(param.item_Name == $rootScope.selectToOrder[i].item_Name){
					$rootScope.selectToOrder.splice(i, 1, {
						item_No: $rootScope.selectToOrder[i].item_No,
						item_Name: $rootScope.selectToOrder[i].item_Name,
						order_No: $rootScope.selectToOrder[i].order_No,
						order_Way: $rootScope.TableName,
						item_Amount: 0,
						item_Price: 0,
						del_yn: "Y"
					});
				}
				$scope.howmuch();
			}
		};
		
	};
	
	$scope.howmuch = () => {
		$scope.result = 0;
		for(var i=0; i<$rootScope.selectToOrder.length; i++){
			$scope.result += $rootScope.selectToOrder[i].item_Price;
			$rootScope.sellItem.sell_Result = $scope.result;
		}
	};
	
	$scope.calclick = (param) => {
		$scope.calput.result = $scope.calput.result + "" + param;
		$scope.calboo = () => {
			$scope.calput.result = "";
		};
		
	};
	
	$rootScope.toSave = () => {
		if($rootScope.selectToOrder.length == 0){
			$rootScope.toStartPos();
		} else {
				for(var i=0; i<$rootScope.selectToOrder.length; i++){
					$rootScope.selectToOrder[i]["order_Way"] = $rootScope.TableName;
					$rootScope.selectToOrder[i]["address"] = $rootScope.loginUser.address;
					$rootScope.selectToOrder[i]["user_ID"] = $rootScope.loginUser.user_ID;
					$rootScope.selectToOrder[i]["TableName"] = $rootScope.TableName;
				}
				
				$http.post("orderList", "", {params:$rootScope.loginUser}).then(function(result){
					if(result.data.list.length == 0){
						
						$scope.inOrder = {
								user_ID: $rootScope.loginUser.user_ID,
								order_Way: $rootScope.TableName
						};
						
						$http.post("addOrder1", "", {params:$scope.inOrder}).then(function(result){
							
							$scope.addTem();
							$rootScope.toStartPos();
						}), function(result){
						};
						
						location.reload();
					} else {
						
						for(var i=0; i<$rootScope.itemIndex.length; i++){
							if($rootScope.itemIndex[i].order_Way == $rootScope.TableName){
								var namechc = true;
								break;
							} else {
								var namechc = false;
							}
						}
						if(!namechc){
							$scope.inOrder = {
									user_ID: $rootScope.loginUser.user_ID,
									order_Way: $rootScope.TableName
							};
							$http.post("addOrder2", "", {params:$scope.inOrder}).then(function(result){
								
								$scope.addTem();
								location.href = "#!/start";
							}), function(result){
							};
							location.reload();
						} else {
							
							for(var i=0; i<$rootScope.itemIndex.length; i++){
								if($rootScope.itemIndex[i].order_Way == $rootScope.TableName){
								$scope.orderNum = {
										order_No: $rootScope.itemIndex[i].order_No
								};
								break;
								}
							}
							for(var i=0; i<$rootScope.selectToOrder.length; i++){
								if($rootScope.selectToOrder[i].order_No == undefined){
									$rootScope.selectToOrder[i]["order_No"] = $scope.orderNum.order_No;
								}
								$http.post("listUpdating", "", {params: $rootScope.selectToOrder[i]}).then(function(result){
								}), function(result){
								};
							}
							location.reload();
						}
					}
				}), function(result){
				};
		}
	};
			
	
	$scope.addTem = () => {
		for(var i=0; i<$rootScope.selectToOrder.length; i++){
			$http.post("orderDetail", "", {params:$rootScope.selectToOrder[i]}).then(function(result){
			}), function(result){
			};
		}
	};
	
	$scope.initToOrder = () => {
		if($rootScope.itemIndex != null){
			for(var i=0; i<$rootScope.itemIndex.length; i++){
				if($rootScope.itemIndex[i].order_Way == $rootScope.TableName){
					$rootScope.selectToOrder.push($rootScope.itemIndex[i]);
				} 
			}
		} else if ($rootScope.itemIndex == null){
			console.log("디비에 값이 없어");
		}
	};

	$scope.Tablechk = () => {
		if($rootScope.TableName == null){
			$rootScope.toStartPos();
		}
	};
	
	$scope.btn2 = (param) => {
		
		if($rootScope.selectToOrder.length == 0){
			location.href = "#!/start";
		} else {
			$rootScope.sellItem["sell_Way"] = param;
			$rootScope.sellItem["sell_Total"] = $scope.result;
			$rootScope.sellItem["sell_Sub"] = $rootScope.sellItem.sell_Total - $rootScope.sellItem.sell_SubTo;
			if(($scope.calput.result == "") && ($rootScope.sellItem.sell_SubTo == undefined)){
				$rootScope.sellItem.sell_Sub = $scope.result;
			} else if (($scope.calput.result != "") && ($rootScope.sellItem.sell_SubTo == undefined)){
				$rootScope.sellItem.sell_Sub = $scope.calput.result;
			}
			if($rootScope.sellItem.sell_Result != $scope.result){
				$rootScope.sellItem.sell_Result = $rootScope.sellItem.sell_Total - ($rootScope.sellItem.sell_Sub + $rootScope.sellItem.sell_SubTo);
			} else if($rootScope.sellItem.sell_Result == null){
				$rootScope.sellItem.sell_Result = $rootScope.sellItem.sell_Sub;
			}
			if($rootScope.sellItem.sell_Way == "cash"){
				if($rootScope.sellItem.sell_Total < $rootScope.sellItem.sell_Sub){
					$rootScope.sellItem["return"] = $rootScope.sellItem.sell_Sub - $rootScope.sellItem.sell_Total;
				}
			}
			
			$scope.toss = {
					user_ID: $rootScope.loginUser.user_ID,
					order_Way: $rootScope.selectToOrder[0].order_Way,
					sell_Way:$rootScope.sellItem.sell_Way,
					sell_Sub : $rootScope.sellItem.sell_Sub
			};
			$http.post("orderListforOrderWay", "", {params: $scope.toss}).then(function(result){
				if(result.data.add == 0){

					for(var i=0; i<$rootScope.selectToOrder.length; i++){
						$rootScope.selectToOrder[i]["user_ID"] = $rootScope.loginUser.user_ID;
						$rootScope.selectToOrder[i]["order_No"] = 1;
					}
					
					$scope.addTem();
					
				} else if(result.data.add == 1){

					for(var i=0; i<$rootScope.selectToOrder.length; i++){
						$rootScope.selectToOrder[i]["user_ID"] = $rootScope.loginUser.user_ID;
						$rootScope.selectToOrder[i]["order_No"] = result.data.order_No;
					}
					$scope.addTem();
					
				} else if (result.data.add == 2){
					
					for(var i=0; i<$rootScope.itemIndex.length; i++){
						if($rootScope.itemIndex[i].order_Way == $rootScope.TableName){
						$scope.orderNum = {
								order_No: $rootScope.itemIndex[i].order_No
						};
						break;
						}
					}
					
					for(var i=0; i<$rootScope.selectToOrder.length; i++){
						if($rootScope.selectToOrder[i].order_No == undefined){
							$rootScope.selectToOrder[i]["order_No"] = $scope.orderNum.order_No;
						}
						$http.post("listUpdating", "", {params: $rootScope.selectToOrder[i]}).then(function(result){
						}), function(result){
						};
						
					}
					
				}
			}), function(result){
			};
			
			$("#sellModal").modal("show");
		}
	};
	
	$rootScope.pay = () => {
		$scope.toss["order_No"] = $rootScope.selectToOrder[0].order_No;
		$scope.toss["sell_Card"] = $rootScope.card.name;
		$scope.toss["sell_CardNum"] = $rootScope.cardput.result;
		
		$http.post("Finish", "",{params:$scope.toss}).then(function(result){
			if(result.data.cardNull == 1){
				alert("정확한 정보가 아니여서 결제가 실패하였습니다.");
			}
			if(result.data.sold == 1){
				console.log("sold 가 1");
			}
		}), function(result){
		};
		$("#sellModal").modal("hide");
		location.reload();
	};
	
	$rootScope.cardclick = (param) => {
		$rootScope.cardput.result = $rootScope.cardput.result + "" + param;
		if(param == "clear"){
			$rootScope.cardput.result = "";
		}
		$scope.toss["sell_CardNum"] = $rootScope.cardput.result;
	};
	
	$scope.forResultSeacrh = () => {
		if($rootScope.selectToOrder.length > 0){
			$scope.params = {
					user_ID: $rootScope.loginUser.user_ID,
					order_No: $rootScope.selectToOrder[0].order_No
			};
			$http.post("forResult", "", {params: $scope.params}).then(function(result){
				
				if(result.data.result == null){
					$rootScope.sellItem.sell_Result = $scope.result;
				} else{
					$rootScope.sellItem.sell_Total = $scope.result;
					$rootScope.sellItem.sell_Result = result.data.result.sell_Result;
					$rootScope.sellItem["sell_SubTo"] = result.data.result.sell_Total;
				}
				
			}), function(result){
			};
		}
	};
	
	$scope.Tablechk();
	$scope.categoryList();
	$scope.initToOrder();
	$scope.howmuch();
	$scope.forResultSeacrh();
	
});