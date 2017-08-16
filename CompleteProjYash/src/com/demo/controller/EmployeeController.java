package com.demo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.bean.User;
import com.model.bl.LoginCheck;

public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EmployeeController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		LoginCheck lc = new LoginCheck();
		User user = new User();
		
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		
		if (lc.check(user)) {
			HttpSession session = request.getSession();
			session.setAttribute("LoginUser", user);
			response.sendRedirect("http://localhost:8089/CompleteProjYash/Home.jsp");
		} else {
			pw.println("Login Failed !!");
		}
	}

}
