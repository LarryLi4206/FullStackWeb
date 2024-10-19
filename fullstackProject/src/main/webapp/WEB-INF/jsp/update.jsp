<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!--資源加載-->
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

<title>取得session後更新資料</title>
</head>
<body>

<form id="update_form">
        會員編號:<input id="u_auto_id" type="text" style="border: none" value="${sessionScope.Logindata.customer_id}" readonly><br>
        會員姓名:<input id="u_name" type="text" value="${sessionScope.Logindata.customer_name}"><br>
        帳號:<input id="u_account" type="text" value="${sessionScope.Logindata.account}"><br>
        密碼:<input id="u_password" type="text" value="${sessionScope.Logindata.password}"><br>
        聯絡地址:<input id="u_addr" type="text" value="${sessionScope.Logindata.address}"><br>
        信箱:<input id="u_mail" type="text" value="${sessionScope.Logindata.mail_address}"><br>
        聯絡電話:<input id="u_tel" type="text" value="${sessionScope.Logindata.telephone}"><br>
        會員等級:<input id="u_level" style="border:none;" type="text" value="${sessionScope.Logindata.vip}" readonly><br>
        <button id="up_bt1">更新</button><br>
    </form>
    <div id="u_result"></div>
<script>

function Cupdate(event){
	alert("function---");
	var Ucus_id=$("#u_auto_id").val();
	var Uname=$("#u_name").val();
	var Uaccount=$("#u_account").val();
	var Upassword=$("#u_password").val();
	var Uaddress=$("#u_addr").val();
	var Umail=$("#u_mail").val();
	var Utel=$("#u_tel").val();
	var Uvip=$("#u_level").val();

	Uobj={
		"customer_id" : Ucus_id,
		"customer_name" : Uname,
		"account" : Uaccount,
		"password" : Upassword,
		"address" : Uaddress,
		"mail_address" : Umail,
		"telephone" : Utel,
		"vip" : Uvip
	}
	console.log(JSON.stringify(Uobj));
	$.ajax({
        method:"PUT",
        url: "/fullstackProject/customer/cupdate",
        contentType: "application/json",
        data: JSON.stringify(Uobj),
        dataType:"html",
        statusCode: { //依不同StatusCode執行不同邏輯                        
                        201: function (res, stausText, xhr) {
                            alert("201-Location=" + 
                                //透過XHR取出Response Header
                                xhr.getResponseHeader("Location"));
                        },
                        404: function () {
                            alert("Page Not Found!");
                        },
                        304: function () {
                            alert("Data Not Modified!");
                        },
                        500: function (xhr, statusText, err) {
                            alert(xhr.responseText);
                        }
                },
        success:function(data){
            alert("success");
            $("#u_result").html(data);
        },
        error:function(data){
            alert("fail");
            $("#u_result").html(data);
        }
    });
    event.preventDefault();//阻止表單默認提交
}
function start(){
	$("#up_bt1").click(Cupdate);
}

$(document).ready(start);
</script>
</body>
</html>