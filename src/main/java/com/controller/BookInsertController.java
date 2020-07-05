package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.BookBean;
import com.dao.BookDao;
import com.util.ValidationsUtil;

/**
 * Servlet implementation class BookInsertController
 */
public class BookInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String bName  = request.getParameter("txtBookName");
		int bQty = Integer.parseInt(request.getParameter("txtBookQty"));
		int bPrice = Integer.parseInt(request.getParameter("txtBookPrice"));
		int aId = Integer.parseInt(request.getParameter("aid"));
		
		//data
		
		System.out.println(bName);  //dao -->
		boolean isError = false;
		BookBean bookBean = new BookBean();//bean-->
		
		if(ValidationsUtil.isEmpty(bName)){
			
			isError = true;
			request.setAttribute("bname", "book name is required");
		}
		
		else{
		
			bookBean.setbName(bName);
		}
		
		if(isError == false)
		{
		
		bookBean.setbPrice(bPrice);
		bookBean.setbQty(bQty);
		bookBean.setaId(aId);
		
		
		
		if(new BookDao().addBook(bookBean)){
			
			
			response.sendRedirect("success.html");
			
		}
		
		else{
			
			response.sendRedirect("error.html");
		}
		
		}
		
		else{
			
				request.getRequestDispatcher("insertBook.jsp").forward(request, response);
			
		}
		
		
	}

}
