package com.iot.test.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import com.iot.test.vo.Customer;

// @WebServlet(name="jspServlet", urlPatterns= {"/view/*"})
public class JspServlet extends HttpServlet{
	
	private MenuService ms = new MenuServiceImpl();
	
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
		String uri=req.getRequestURI();
		String root=req.getContextPath();
		uri=uri.replace(root, "");
		ms.getMenuList(req);	
		if(uri.indexOf("user/list")!=-1) {
			UserService us=new UserServiceImpl();
			us.getUserList(req);			
		}else if(uri.indexOf("class/list")!=-1) {
			ClassService cs = new ClassServiceImpl();
			cs.getClassList(req);
		}else if(uri.indexOf("class/insert")!=-1){
			ClassService cs = new ClassServiceImpl();
			cs.insertClass(req);
			uri=uri.replace("insert.jsp", "list");
			cs.getClassList(req);
		}else if(uri.indexOf("class/upanddel")!=-1) {
			ClassService cs = new ClassServiceImpl();
			String deleteKey = req.getParameter("deleteName");
			String updateKey = req.getParameter("updateName");
			if(deleteKey!=null) {
				int result = cs.deleteClass(req);
				System.out.println(result);
				if(result>=1) {
					System.out.println("삭제성공");
				}else{
					System.out.println("삭제실패");
				}
			}
			if(updateKey!=null) {
				int result = cs.updateClass(req);
				if(result>=1) {
					System.out.println("수정성공");
				}else {
					System.out.println("수정실패");
				}
			}
			System.out.println(uri);
			uri=uri.replace("upanddel.jsp", "list");
			System.out.println(uri);
			cs.getClassList(req);
		}else if(uri.indexOf("customer/list")!=-1) {
			System.out.println("서블렛 > 커스텀 > 리스트");
			CustomerService cs = new CustomerServiceImpl();
			cs.setCustomerList(req);
		}else if(uri.indexOf("customer/insert")!=-1) {
			CustomerService cs = new CustomerServiceImpl();
			cs.insertCustomer(req);
		}else if(uri.indexOf("customer/upanddel")!=-1) {
			System.out.println("커스텀 업앤딜 서블릿옴?");
			CustomerService cs = new CustomerServiceImpl();
			String deleteKey = req.getParameter("deleteKey");
			String updateKey = req.getParameter("updateKey");
			if(deleteKey!=null) {
				int result = cs.deleteCustomer(req);
				if(result>=1) {
					System.out.println("삭제성공");
				}else {
					System.out.println("삭제실패");
				}
			}
			if(updateKey!=null) {
				int result = cs.updateCustomer(req);
				if(result>=1) {
					System.out.println("수정성공");
				}else {
					System.out.println("수정실패");
				}
			}
			uri=uri.replace("upanddel.jsp", "list");
			System.out.println(uri);
			cs.getCustomerList(req);
		}
			
		
		uri = "/WEB-INF"+uri+".jsp";		
		RequestDispatcher rd = req.getRequestDispatcher(uri);
		rd.forward(req, res);
	}


	
	
}
