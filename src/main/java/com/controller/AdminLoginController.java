package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.AdminBean;
import com.dao.AdminDao;

/**
 * Servlet implementation class AdminLoginController
 */
public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String aEmail = request.getParameter("txtAdminEmail");
		String aPassword = request.getParameter("txtAdminPassword");

		AdminBean adminBean = new AdminDao().loginAdmin(aEmail, aPassword);
		HttpSession session = request.getSession();
		
		if (adminBean != null) {

			session.setAttribute("adminBean", adminBean);//cokkie
			/// home,....
			System.out.println(adminBean.getaName());

		} else {

			request.setAttribute("error", "pls check username or passsword...");
			request.getRequestDispatcher("AdminLogin.jsp").forward(request, response);
		}

	}

}
