package com.iot.test.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	public int inserClass(ClassInfo ci) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateClass(ClassInfo ci) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteClass(ClassInfo ci) {
		// TODO Auto-generated method stub
		return 0;
	}



	
}