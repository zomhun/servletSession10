<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Display Account</h1>
	<h3 style="color:green">${success}</h3>
	<h3 style="color:red">${error}</h3>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Full Name</th>
			<th>Gender</th>
			<th>Birthday</th>
			<th>Address</th>
			<th>Email</th>
			<th>Phone</th>
		</tr>
		<c:forEach items="${list}" var="acc">
			<tr>
				<td>${acc.id}</td>
				<td>${acc.fullName}</td>
				<td>${acc.gender?"Male":"Female"}</td>
				<td><fmt:formatDate value="${acc.birthday}" pattern="dd/MM/yyyy"/></td>
				<td>${acc.address}</td>
				<td>${acc.email}</td>
				<td>${acc.phone}</td>
				<td>
					<a href="DetailAcc?id=${acc.id}">Update</a>
					<a href="DeleteAcc?id=${acc.id}">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<a href="insert.jsp">Insert</a>
</body>
</html>