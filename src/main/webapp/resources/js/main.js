var app = angular.module("posApp",
		["ngRoute", "Home", "Login", "Pos", "Write", "Management", "Adduser", "SignUp", "OrderItem", "ItemManag", "OrderList",
			"SellList", "Sales", "StartPos", "Seller"]);

app.config(function($routeProvider){
	$routeProvider.when("/", {
		templateUrl : "resources/html/main.html",
		controller : "home"
	}).when("/pos", {
		templateUrl : "resources/html/pos.html",
		controller : "pos"
	}).when("/login", {
		templateUrl : "resources/html/login.html",
		controller : "login"
	}).when("/management", {
		templateUrl : "resources/html/management.html",
		controller : "management"
	}).when("/adduser", {
		templateUrl : "resources/html/addUser.html",
		controller : "adduser"
	}).when("/write", {
		templateUrl : "resources/html/write.html",
		controller : "write"
	}).when("/read", {
		templateUrl : "resources/html/read.html"
	}).when("/signup", {
		templateUrl : "resources/html/signup.html",
		controller : "signup"
	}).when("/orderitem", {
		templateUrl : "resources/html/orderItem.html",
		controller : "orderitem"
	}).when("/itemManag", {
		templateUrl : "resources/html/ItemManag.html",
		controller : "itemManag"
	}).when("/itemCreate", {
		templateUrl : "resources/html/itemCreate.html",
		controller : "itemManag"
	}).when("/orderList", {
		templateUrl : "resources/html/OrderList.html",
		controller : "orderList"
	}).when("/sellList", {
		templateUrl : "resources/html/sellList.html",
		controller : "sellList"
	}).when("/sales", {
		templateUrl : "resources/html/sales.html",
		controller : "sales"
	}).when("/start", {
		templateUrl : "resources/html/Start.html",
		controller : "startPos"
	}).when("/seller", {
		templateUrl : "resources/html/seller.html",
		controller : "seller"
	}).otherwise({redirectTo: "/"})
	
});

app.run(function($rootScope, $location, $http, $q, FileService){
	$rootScope.nav =  'resources/html/nav.html';
	$rootScope.side = 'resources/html/side.html';
	$rootScope.toMain = () => {
		$location.path('/');
	};
	$rootScope.toLogout = () => {
		$http.post("logout").then(function(result){$rootScope.loginUser = null}),function(){};
		$rootScope.onchk = false;
		$rootScope.toMain();
	};
	$rootScope.toSignup = () => {
		$location.path('/signup');
	};
	$rootScope.toSeller = (param) => {
		$rootScope.TableName = param;
		$location.path('/seller');
	};
	$rootScope.toStartPos = () => {
		$location.path('/start');
	};
	$rootScope.toPos = () => {
		$location.path('/pos');
	};
	$rootScope.toLogin = () => {
		$location.path('/login');
	};
	$rootScope.toWrite = () => {
		$location.path('/write');
	};
	$rootScope.toRead= () => {
		$location.path('/read');
	};
	$rootScope.toManagement = () => {
		$location.path('/management');
		$rootScope.userList();
	};
	$rootScope.toItemManag = () => {
		$location.path('/itemManag');
	};
	$rootScope.detailBoard = {
			no:"",
			title:"",
			contents:""
	};
	$rootScope.UserList = [];
	
	$rootScope.userList = () => {
		
		$http.post("userList", "", {params:$rootScope.loginUser}).then(function(result){
			$rootScope.UserList = result.data.list;
		}), function(result){
		};
	};
	
	$rootScope.keepUser = () => {
		$rootScope.rootKeepChk = true;
		if($rootScope.loginUser == null){
			$http.post("keepUser").then(function(result){
				if(result.data.stat == 0){
					$rootScope.toMain();
					$rootScope.rootKeepChk = false;
				} else if(result.data == "null") {
					$rootScope.toMain();
					$rootScope.rootKeepChk = false;
				} else {
					$rootScope.onchk = true;
					$rootScope.loginUser = result.data.logonUser;
					if($rootScope.loginUser.authority == "ROLE_ADMIN"){
						$rootScope.loginchk = true;
						$rootScope.rootKeepChk = true;
					} else{
						$rootScope.loginchk = false;
						$rootScope.rootKeepChk = true;
					}
				}
			}), function(result){
			};
		} else {
			$rootScope.onchk = true;
			$rootScope.rootKeepChk = true;
			if($rootScope.loginUser.authority == "ROLE_ADMIN"){
				$rootScope.loginchk = true;
			} else{
				$rootScope.loginchk = false;
			}
		}
	};
	
	$rootScope.keepUser();
	
});

app.factory("FileService", function($http, $q){
	var deffered = $q.defer();
	var result =[];
	var FileService = {};
	
	FileService.async = function(url, formData, param){
		$http.post(url, formData, { //url, param 데이터
			headers : {"Content-Type": undefined},
			params : param
		}).then(data => {
			result = data;
			deffered.resolve();
		}, data => {
			result = data;
			deffered.resolve();
		});
		//promise : 데이터 검증
		return deffered.promise;	
	}
	
	FileService.data = function(){ return result; }
	
	return FileService;
});

app.directive("moDal", function(){
	return {
		rootScope: {
			reservItem : "="
		},
		templateUrl : 'resources/html/reservModal.html'
	}
});

app.directive("moDdal", function(){
	return {
		rootScope: {
			sellItem : "="
		},
		templateUrl : 'resources/html/modalSell.html'
	}
});