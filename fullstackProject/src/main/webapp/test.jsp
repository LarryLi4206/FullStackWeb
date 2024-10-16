<!DOCTYPE html>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!--資源加載-->
<!-- Latest compiled and minified CSS -->
<!-- 
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
 -->	
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<!-- Popper JS -->
<!-- 
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
 -->	
<!-- Latest compiled JavaScript -->
<!--  
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
-->	
</head>
<body>

	<form action="#" method="post">
		名字:<input type="text" id="name" name="customer_name" value="cpu"><br>
		帳號:<input type="text" id="account" name="account" value="cpu1234"><br>
		密碼:<input type="text" id="password" name="password" value="123456"><br>
		<button id="bt1" type="submit">send</button>
	</form>
	
	<div id="page"></div>
	<script>
		function send(event) {
			var name = $("name").val;
			var account = $("account").val;
			var password = $("password").val;
			var obj = {
				"Customer_name" : name,
				"Account" : account,
				"Password" : password
			}

			$.ajax({
				method : "POST",
				url : "http://localhost:8080/fullstackProject/customer/login",
				contentType : "application/x-www-form-urlencoded;charset=utf-8",
				data : $(form).serializeArray(),
				dataType : 'html',
				success : function() {
					$("#page").html(data);
				},
				error : function() {
					$("#page").html(data);
				}
			});
			event.preventDefault();//阻止表單提交
		}
		function start() {
			$("#b1").click(send);
		}
		$(document).ready(start);
	</script>
</body>
</html>