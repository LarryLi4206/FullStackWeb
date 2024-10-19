<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!--資源加載-->
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

<meta charset="UTF-8">
<title>顧客註冊</title>
</head>
<body>

 	<form method="post" id="form_data">
        會員編號:<input id="auto_id" type="text" style="border: none" value="${AutoProductCustomerId}" readonly><br>
        會員姓名:<input id="name" type="text" value="fish"><br>
        帳號:<input id="account" type="text" value="fish1234"><br>
        密碼:<input id="password" type="text" value="123456"><br>
        聯絡地址:<input id="addr" type="text" value="12346"><br>
        信箱:<input id="mail" type="text" value="123456"><br>
        聯絡電話:<input id="tel" type="text" value="122456"><br>
        會員等級:<input id="level" style="border:none;" type="text" value="註冊完成為一般會員，首次享結帳9折" readonly><br>
        <button id="bt1" onclick="">send</button><br>
    </form>
    <div id="result"></div>
    
    <script>

function register(event){
    
    var customer_id=$("#auto_id").val();
    var customer_name=$("#name").val();
    var account=$("#account").val();
    var password=$("#password").val();
    var address=$("#addr").val();
    var mail_address=$("#mail").val();
    var telephone=$("#tel").val();
    var vip="一般會員";

    obj={
        "customer_id" : customer_id,
        "customer_name" : customer_name,
        "account" : account,
        "password" : password,
        "address" : address,
        "mail_address" : mail_address,
        "telephone" : telephone,
        "vip" : vip
    }

    $.ajax({
        method:"POST",
        url: "/fullstackProject/customer/register",
        contentType: "application/json",
        data: JSON.stringify(obj),
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
            $("#result").html(data);
        },
        error:function(data){
            $("#result").html(data);
        }
    });
    event.preventDefault();//阻止表單默認提交
}
function start(){
    $("#bt1").click(register);
}

$(document).ready(start);

</script>
    
</body>
</html>