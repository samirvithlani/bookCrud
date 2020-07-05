package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.BookBean;
import com.dao.BookDao;

/**
 * Servlet implementation class BookListController
 */
public class BookListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		List<BookBean> listOfBooks = new ArrayList<BookBean>();
		
		listOfBooks = new BookDao().bookList();  
		request.setAttribute("booklist", listOfBooks);
		request.getRequestDispatcher("BookList.jsp").forward(request, response);  //url of page
		
	}
	
	

}
