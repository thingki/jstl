package com.iot.test.DAO;

import java.util.List;

import com.iot.test.vo.Customer;

public interface CustomerDAO {
	public List<Customer> selectCustomerList(Customer cus, String orderStr, String type);
	public List<Customer> selectCustomerList(Customer cus);
	public Customer selectCustomer(Customer cus);
	public int inserCustomer(Customer cus);
	public int updateCustomer(Customer cus);
	public int deleteCustomer(String updateKey);

}
