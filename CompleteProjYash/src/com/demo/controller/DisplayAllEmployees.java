package com.demo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.bl.EmployeeBL;

public class DisplayAllEmployees extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DisplayAllEmployees() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		EmployeeBL emp = new EmployeeBL();
		session.setAttribute("AllEmployees", emp.listAllEmployees());
		response.sendRedirect("./AllEmp.jsp");
	}
}
