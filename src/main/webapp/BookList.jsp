<%@page import="com.bean.AdminBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bean.BookBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>booklist</title>
</head>
<body>

	
	
	
	<%
		AdminBean adminBean = (AdminBean)session.getAttribute("adminBean");
		if(adminBean!=null){
	
		List<BookBean> listofBooks = (ArrayList) request.getAttribute("booklist");
	%>
	<h3>LOGGEDIN USER<%=adminBean.getaName() %></h3>
	<h4>${adminBean.aName }</h4>
	<h1><a href="AdminLogoutController">LOGOUT</a></h1>

	<table background="pink" border="2" bgcolor="yellow" align="center">

		<tr>
			<th>Book Id</th>
			<th>Book Name</th>
			<th>Book Price</th>
			<th>Book Qty</th>
			<th>ACTION</th>
		</tr>

		<tr>
			<%
				for (int i = 0; i < listofBooks.size(); i++) {

						BookBean bookBean = listofBooks.get(i);
			%>

			<td><%=bookBean.getbId()%></td>
			<td><%=bookBean.getbName()%></td>
			<td><%=bookBean.getbPrice()%></td>
			<td><%=bookBean.getbQty()%></td>
			<td><a href="BookDeleteController?bid=<%=bookBean.getbId()%>">DELETE</a></td>
			<td><a href="BookEditController?bid=<%=bookBean.getbId()%>">UPDATE</a></td>
		</tr>

		<%
			}
			} else {
				response.sendRedirect("AdminLogin.jsp");
			}
		%>
	</table>

</body>
</html>