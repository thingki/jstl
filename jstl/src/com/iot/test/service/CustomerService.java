package com.iot.test.service;

import javax.servlet.http.HttpServletRequest;

public interface CustomerService {
	public void setCustomerList(HttpServletRequest req);
	public void getCustomerList(HttpServletRequest req);
	public void getCustomer(HttpServletRequest req);
	public void insertCustomer(HttpServletRequest req);
	public int updateCustomer(HttpServletRequest req);
	public int deleteCustomer(HttpServletRequest req);
	

}
