<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html data-ng-app="posApp">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="shortcut icon" type="image/x-icon">
	
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    
    <link rel="stylesheet" href="resources/css/pos.css">
    <link rel="stylesheet" href="resources/css/login.css">
    <link rel="stylesheet" href="resources/css/main.css">
    <link rel="stylesheet" href="resources/css/write.css">
    <link rel="stylesheet" href="resources/css/read.css">
    <link rel="stylesheet" href="resources/css/management.css">
    <link rel="stylesheet" href="resources/css/signup.css">
    <link rel="stylesheet" href="resources/css/orderItem.css">
    <link rel="stylesheet" href="resources/css/ItemManag.css">
    <link rel="stylesheet" href="resources/css/OrderList.css">
    <link rel="stylesheet" href="resources/css/sellList.css">
    <link rel="stylesheet" href="resources/css/sales.css">
    <link rel="stylesheet" href="resources/css/Start.css">
    <link rel="stylesheet" href="resources/css/seller.css">
    <link rel="stylesheet" href="resources/css/modalSell.css">
    
    <script type="text/javascript" src="resources/angular/angular.min.js"></script>
	<script type="text/javascript" src="resources/angular/angular-route.min.js"></script>
	<script type="text/javascript" src="resources/js/main.js"></script>
	<script type="text/javascript" src="resources/js/home.js"></script>
	<script type="text/javascript" src="resources/js/login.js"></script>
	<script type="text/javascript" src="resources/js/pos.js"></script>
	<script type="text/javascript" src="resources/js/write.js"></script>
	<script type="text/javascript" src="resources/js/management.js"></script>
	<script type="text/javascript" src="resources/js/adduser.js"></script>
	<script type="text/javascript" src="resources/js/signup.js"></script>
	<script type="text/javascript" src="resources/js/orderitem.js"></script>
	<script type="text/javascript" src="resources/js/itemManag.js"></script>
	<script type="text/javascript" src="resources/js/orderList.js"></script>
	<script type="text/javascript" src="resources/js/listSell.js"></script>
	<script type="text/javascript" src="resources/js/sales.js"></script>
	<script type="text/javascript" src="resources/js/start.js"></script>
	<script type="text/javascript" src="resources/js/seller.js"></script>

<title>POS</title>
</head>
<body>
	
	<div data-ng-include="nav"></div>
	
	<div data-ng-include="side"></div>
	
	<div class="content" data-ng-view></div>
	
	<mo-dal modal-data="reservModal"></mo-dal>
	<mo-ddal modal-data="sellModal"></mo-ddal>
</body>
</html>