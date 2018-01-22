package com.iot.test.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.iot.test.DAO.ClassDAO;
import com.iot.test.common.DBCon;
import com.iot.test.common.DBUtil;
import com.iot.test.vo.ClassInfo;

public class ClassDAOImpl implements ClassDAO {

	@Override
	public List<ClassInfo> selectClassList(ClassInfo ci, String orderStr, String typeStr) {
		List<ClassInfo> classList = new ArrayList<ClassInfo>();
		String sql = "select * from class_info where 1=1";
		if(ci != null) {
			sql += " and ciname like ?";
		}
		if(orderStr != null) {
			sql += " order by "  + typeStr;
		}
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DBCon.getCon();
			ps = con.prepareStatement(sql);
			if(ci != null) {
				ps.setString(1, "%"+ci.getCiName()+"%");
			}
			rs = ps.executeQuery();
			while(rs.next()) {
				ClassInfo ci2 = new ClassInfo();
				ci2.setCiNo(rs.getInt("ciNo"));
				ci2.setCiName(rs.getString("ciName"));
				ci2.setCiDesc(rs.getString("ciDesc"));
				classList.add(ci2);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(rs, con, ps);
		}
		return classList;
	}
	
	@Override
	public ClassInfo selectClass(ClassInfo ci) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int inserClass(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBCon.getCon();
			String sql = "insert into class_info(ciname, cidesc)\r\n" + 
							"values(?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, req.getParameter("ciname"));
			ps.setString(2, req.getParameter("cidesc"));
			
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
	public int updateClass(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBCon.getCon();
			String sql = "update class_info set ciname=?, cidesc=? where cino=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, req.getParameter("ciName"));
			ps.setString(2, req.getParameter("ciDesc"));
			ps.setString(3, req.getParameter("updateName"));
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
	public int deleteClass(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBCon.getCon();
			String sql = "delete from class_info where cino=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, req.getParameter("deleteName"));
			return ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(con);
			DBUtil.close(ps);
		}	
		return 0;
	}



	
}
