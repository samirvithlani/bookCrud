<%@page import="com.bean.AuthorBean"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.AuthorDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="BookInsertController">
		<!-- url patterm -->
		<table>
			<tr>
				<td>BOOK NAME:-</td>
				<td><input type="text" name="txtBookName"> ${bname }</td>
			</tr>

			<tr>
				<td>BOOK PRICE:-</td>
				<td><input type="text" name="txtBookPrice"></td>
			</tr>

			<tr>
				<td>BOOK QTY:-</td>
				<td><input type="text" name="txtBookQty"></td>
			</tr>

			<tr>
				<td>AUTHOR</td>
				<td><select name="aid">
						<option value="0">SELECT AUTHOR</option>
						<%
							AuthorDao authorDao = new AuthorDao();
							List<AuthorBean> list = authorDao.authorList();
							for (int i = 0; i < list.size(); i++) {
								AuthorBean authorBean = list.get(i);
						%>
						<option value="<%=authorBean.getaId()%>"><%=authorBean.getaName()%></option>
						<%
							}
						%>
				</select></td>
			</tr>

			<tr>

				<td><input type="submit" value="SUBMIT"></td>
			</tr>


		</table>

	</form>
</body>
</html>