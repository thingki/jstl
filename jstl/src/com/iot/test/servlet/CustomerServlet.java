package com.iot.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iot.test.service.ClassService;
import com.iot.test.service.CustomerService;
import com.iot.test.service.MenuService;
import com.iot.test.service.UserService;
import com.iot.test.service.impl.ClassServiceImpl;
import com.iot.test.service.impl.CustomerServiceImpl;
import com.iot.test.service.impl.MenuServiceImpl;
import com.iot.test.service.impl.UserServiceImpl;

public class CustomerServlet extends HttpServlet {

	private MenuService ms = new MenuServiceImpl();
	private CustomerService cs = new CustomerServiceImpl();
	
	private String getCommand(String uri) {
		int idx = uri.lastIndexOf("/");
		if (idx != -1) {
			return uri.substring(idx + 1);
		}
		return "";
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req, res);
	}

	private void doProcess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");

		PrintWriter out = res.getWriter();
		String uri = req.getRequestURI();
		System.out.println(uri);
		String cmd = getCommand(uri);
		uri = uri.replace(cmd, ""); // uri 에서 명령어 삭제 > uri=/jstl/customer/

		System.out.println("커스텀서블랫" + cmd + "uri = "+ uri);

		ms.getMenuList(req);
		if(cmd.equals("insert")) {
			cs.insertCustomer(req);
		}else if (cmd.equals("update")) {
			cs.updateCustomer(req);
		}else if(cmd.equals("delete")) {
			cs.deleteCustomer(req);
		}
		uri = "/customer/list.jsp";
		RequestDispatcher rd = req.getRequestDispatcher(uri);
		rd.forward(req, res);
	}
}
