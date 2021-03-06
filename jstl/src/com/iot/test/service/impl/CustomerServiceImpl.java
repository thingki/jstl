package com.iot.test.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.iot.test.DAO.CustomerDAO;
import com.iot.test.DAO.impl.CustomerDAOImpl;
import com.iot.test.service.CustomerService;
import com.iot.test.vo.ClassInfo;
import com.iot.test.vo.Customer;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDAO cdao = new CustomerDAOImpl();
	Gson gson = new Gson();
	@Override
	public void getCustomerList(HttpServletRequest req) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getCustomer(HttpServletRequest req) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertCustomer(HttpServletRequest req) {
		String json = req.getParameter("param");
		Customer c = gson.fromJson(json, Customer.class);
		int result = cdao.inserCustomer(c);
		HashMap<String, String> rm = new HashMap<String, String>();
		rm.put("result", "no");
		rm.put("msg", "고객 추가 실패!!");
		if(result ==1) {
			rm.put("result", "ok");
			rm.put("msg", "고객 추가 성공!!!!");
		}											
		req.setAttribute("resStr", gson.toJson(rm));
	}

	@Override
	public int updateCustomer(HttpServletRequest req) {
		int result = cdao.updateCustomer(req);
		return result;

	}

	@Override
	public int deleteCustomer(HttpServletRequest req) {
		int result = cdao.deleteCustomer(req);
		return result;
	}

	@Override
	public void setCustomerList(HttpServletRequest req) {	
		Customer cus = null;
		String json = req.getParameter("SerchCustomerName");
		String orderStr = (String) req.getParameter("order");
		String typeStr = (String) req.getParameter("type");

		if(json!=null) {
			cus=new Customer();
			cus.setCustomerName(json);
		}
		
		if(typeStr==null) {
			typeStr = "customerid asc,customername asc,city asc,country asc";
		}
		
		if(orderStr!=null) {
			int pidex = typeStr.indexOf(orderStr);
			String typePStr = typeStr.substring(pidex);
			int lidex = typePStr.indexOf(",");
			
			if(lidex==-1) {
				typeStr = typeStr.replace(typePStr, "");
				typePStr = typePStr+",";
			}else {
				typePStr = typePStr.substring(0, lidex+1);
				typeStr = typeStr.replace(typePStr, "");
			}
			
			if(typePStr.indexOf("asc,")==-1) {
				typePStr = typePStr.replace("desc,", "asc,");
			}else {
				typePStr = typePStr.replace("asc,", "desc,");
			}		
			typeStr = typePStr + typeStr;
			if(typeStr.lastIndexOf(",")==typeStr.length()-1) {
				typeStr = typeStr.substring(0, typeStr.length()-1);
			}
		}	
		req.setAttribute("customerList", cdao.selectCustomerList(cus, orderStr, typeStr));
		req.setAttribute("type", typeStr);
	}

}
