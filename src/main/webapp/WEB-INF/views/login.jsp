<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="resources/css/login.css">
<title>Login</title>
</head>
<body>
<div class="container" style="text-align: center;">
	<div class="col-sm-12" style="margin-top: 20%;">
		<div class="loginContent">
		    <form action="security_check" method="post">
			    <div class="form-group">
				    <label for="inputUserName">POS - Data management is the first step in everything.</label>
				</div>
				<div class="form-group">
				    <label for="inputUserName">user ID</label>
				    <input class="form-control" placeholder="ID를 입력하세요"
				            type="text" id="inputUserName" name="user_ID"/>
				</div>
				<div class="form-group">
				    <label for="inputPassword">Password</label>
				    <input class="form-control" placeholder="PW를 입력하세요"
				            type="password" id="inputPassword" name="user_PW"/>
				</div>
				<button type="button" class="btn btn-default" id="BackBtn" onclick="location.href='main'">Cancel</button>
				<button type="submit" class="btn btn-default" id="loginBtn">Login</button>
			</form>
		</div>
	</div>
</div>
</body>
</html>