<!DOCTYPE html>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <!--資源加載-->
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>

<form id="form_data" method="POST">
	名稱:<input type="text" id="name" value="cpu" autocomplete="name" placeholder="customer_name"><br>
	帳號:<input type="text" id="account" value="cpu1234" placeholder="account"><br>
	密碼:<input type="text" id="password" value="123456" placeholder="password"><br>
    <button id="bt1">send</button>
</form>
<div id="page"></div>
<script>

function send(event){
    
    var name=$("#name").val();
    var account=$("#account").val();
    var password=$("#password").val();
    obj={
        "name" : name,
        "account" : account,
        "password" : password
    }
    
    $.ajax({
        method: "POST",
        url: "/fullstackProject/customer/login",
        contentType: "application/json",
        //data: $("#form_data").serialize(),
        data:JSON.stringify(obj),
        dataType: "html",
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
        success: function (data){
            $("#page").html(data);
        },
        error: function(data){
            $("#page").html(data);
        }


    });
    event.preventDefault();//阻止表單默認提交
}


function start(){
    //alert('start');
    $("#bt1").click(send);
}


$(document).ready(start);


</script>


</body>
</html>