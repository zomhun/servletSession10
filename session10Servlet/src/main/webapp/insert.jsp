<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Insert Account</h1>
	<h3 style="color:red">${error}</h3>
	<form action="insertAcc" method="post">
		<table>
			<tr>
				<td>Full Name:</td>
				<td><input type="text" name="fullName"/></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password"/></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td><input type="radio" name="gender" value="true" />Male</td>
				<td><input type="radio" name="gender" value="false"/>Female</td>
			</tr>
			<tr>
				<td>Birthday:</td>
				<td><input type="date" name="birthday"/></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><input type="text" name="address"/></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="text" name="email"/></td>
			</tr>
			<tr>
				<td>Phone:</td>
				<td><input type="number" name="phone"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Send" /> <input type="reset"
					value="Clear" /></td>
			</tr>
		</table>
	</form>
</body>
</html>