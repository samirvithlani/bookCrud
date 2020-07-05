package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.BookBean;
import com.dao.BookDao;

/**
 * Servlet implementation class BookUpdateController
 */
public class BookUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String bName = request.getParameter("txtBookName");
		int bQty = Integer.parseInt(request.getParameter("txtBookQty"));
		int bPrice = Integer.parseInt(request.getParameter("txtBookPrice"));
		int bId = Integer.parseInt(request.getParameter("bid"));

		BookBean bookBean = new BookBean();
		bookBean.setbId(bId);
		bookBean.setbName(bName);
		bookBean.setbPrice(bPrice);
		bookBean.setbQty(bQty);

		if (new BookDao().updateBook(bookBean)) {

			response.sendRedirect("BookListController");

		} else {

			response.sendRedirect("BookListController");
		}
	}

}
