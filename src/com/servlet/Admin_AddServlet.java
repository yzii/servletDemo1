package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AdinCrtl;
import com.model.AdminInfo;

public class Admin_AddServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4477413946544485237L;

	/**
	 * Constructor of the object.
	 */
	public Admin_AddServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AdinCrtl ac = new AdinCrtl();
		AdminInfo ai = new AdminInfo();
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		String username =request.getParameter("admin_Name");
		String userpwd =request.getParameter("admin_Pwd");
		
		ai.setAdmin_name(username);
		ai.setAdmin_pwd(userpwd);
		int res=ac.addAdmin(ai);
		if(res>0){
			out.print("<script>alert('add success');window.location.href='../jsp/adminmanage.jsp';</script>");
		}else{
			out.print("<script>alert('add failed');window.history.back();</script>");
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
