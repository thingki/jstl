package com.iot.test.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.iot.test.DAO.CustomerDAO;
import com.iot.test.common.DBCon;
import com.iot.test.common.DBUtil;
import com.iot.test.vo.Customer;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public List<Customer> selectCustomerList(Customer cus) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer selectCustomer(Customer cus) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int inserCustomer(Customer cus) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBCon.getCon();
			String sql = "insert into customer(customername, city, country)\r\n" + 
							"values(?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, cus.getCustomerName());
			ps.setString(2, cus.getCity());
			ps.setString(2, cus.getCountry());
			return ps.executeUpdate();			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(con);
			DBUtil.close(ps);
		}
		return 0;
	}
	
	@Override
	public int updateCustomer(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "update customer set customername=?, city=?, country=? where customerid=?";
		try{
			con = DBCon.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, req.getParameter("customerName"));
			ps.setString(2, req.getParameter("city"));
			ps.setString(3, req.getParameter("country"));
			ps.setString(4, req.getParameter("updateKey"));
			return ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(con);
			DBUtil.close(ps);
		}
		return 0;
	}

	@Override
	public int deleteCustomer(HttpServletRequest req)  {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "delete from customer where customerid=?";
		try{
			con = DBCon.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, req.getParameter("deleteKey"));
			return ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(con);
			DBUtil.close(ps);
		}
		return 0;
	}
	

	@Override
	public List<Customer> selectCustomerList(Customer cus, String orderStr, String typeStr) {
		List<Customer> customerList = new ArrayList<Customer>();
		String sql = "select * from customer where 1=1";
		if(cus != null) {
			sql += " and customername like ?";
		}
		if(orderStr != null) {
			sql += " order by "  + typeStr;
		}
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		con = DBCon.getCon();
		try {
			ps = con.prepareStatement(sql);
			if(cus != null) {
				ps.setString(1, "%"+cus.getCustomerName()+"%");
			}
			
			rs = ps.executeQuery();
			while(rs.next()) {
				Customer c = new Customer();
				c.setCustomerId(rs.getInt("customerid"));
				c.setCustomerName(rs.getString("customername"));
				c.setCity(rs.getString("city"));
				c.setCountry(rs.getString("country"));
				customerList.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(rs, con, ps);

		}
	return customerList;
	}

}
