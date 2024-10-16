<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1" width="80%">
		<thead>
			<tr>
				<th>id</th>
				<th>顧客編號</th>
				<th>顧客姓名</th>
				<th>帳號</th>
				<th>密碼</th>
				<th>地址</th>
				<th>信箱</th>
				<th>電話</th>
				<th>會員等級</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="data" items="${listCustomerData }">
				<tr>
					<td><c:out value=" ${data.id }"></c:out></td>
					<td><c:out value=" ${data.customer_id }"></c:out></td>
					<td><c:out value=" ${data.customer_name }"></c:out></td>
					<td><c:out value=" ${data.account }"></c:out></td>
					<td><c:out value=" ${data.password }"></c:out></td>
					<td><c:out value=" ${data.address }"></c:out></td>
					<td><c:out value=" ${data.mail_address }"></c:out></td>
					<td><c:out value=" ${data.telephone }"></c:out></td>
					<td><c:out value=" ${data.vip }"></c:out></td>
				</tr>
			</c:forEach>
		</tbody>


	</table>


</body>
</html>