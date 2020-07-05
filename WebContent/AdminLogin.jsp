<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${error}
	<form action="AdminLoginController">
		<table>
			<tr>
				<td>ADMIN EMAIL:-</td>
				<td><input type="text" name="txtAdminEmail"></td>
			</tr>


			<tr>
				<td>ADMIN PASSWORD:-</td>
				<td><input type="password" name="txtAdminPassword"></td>
			</tr>


			<tr>

				<td><input type="submit" value="SUBMIT"></td>
			</tr>
		</table>

	</form>
</body>
</html>