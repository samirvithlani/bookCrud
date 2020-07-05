<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="BookUpdateController">
		<!-- url patterm -->
		<input type="hidden" name="bid" value="${bookBean.bId}">
		<table>

			<tr>
				<td>BOOK NAME:-</td>
				<td><input type="text" name="txtBookName"
					value="${bookBean.bName }"></td>
			</tr>

			<tr>
				<td>BOOK PRICE:-</td>
				<td><input type="text" name="txtBookPrice"
					value="${bookBean.bPrice }"></td>
			</tr>

			<tr>
				<td>BOOK QTY:-</td>
				<td><input type="text" name="txtBookQty"
					value="${bookBean.bQty }"></td>
			</tr>

			<tr>

				<td><input type="submit" value="SUBMIT"></td>
			</tr>


		</table>

	</form>
</body>
</html>