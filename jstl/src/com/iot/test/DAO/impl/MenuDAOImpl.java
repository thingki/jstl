package com.iot.test.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iot.test.DAO.MenuDAO;
import com.iot.test.test.DBConTest;
import com.iot.test.common.DBUtil;
import com.iot.test.vo.MenuInfo;

public class MenuDAOImpl implements MenuDAO {

	@Override
	public List<MenuInfo> selectMenuList(MenuInfo mi) {
		ArrayList<MenuInfo> menuList = new ArrayList<MenuInfo>();
		String sql = "select * from menu where 1=1";
		if(mi != null) {
			sql += " and mName like ?";
		}
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		con = DBConTest.getCon();
	
		try {
			ps = con.prepareStatement(sql);
			if(mi != null) {
				ps.setString(1, "%"+mi.getmName()+"%");
			}
			rs = ps.executeQuery();
			while(rs.next()) {
				MenuInfo m = new MenuInfo();
				m.setmNum(rs.getInt("mNum"));
				m.setmName(rs.getString("mName"));
				m.setmUrl(rs.getString("mUrl"));
				m.setmDesc(rs.getString("mDesc"));
				menuList.add(m);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(rs, con, ps);
		}
		return menuList;
	}

	@Override
	public List<MenuInfo> selectMenuList() {
		ArrayList<MenuInfo> menuList = new ArrayList<MenuInfo>();
		String sql = "select * from menu order by mNum";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		con = DBConTest.getCon();
	
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				MenuInfo m = new MenuInfo();
				m.setmNum(rs.getInt("mNum"));
				m.setmName(rs.getString("mName"));
				m.setmUrl(rs.getString("mUrl"));
				m.setmDesc(rs.getString("mDesc"));
				menuList.add(m);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(rs, con, ps);
		}
		return menuList;
	}
	
	@Override
	public MenuInfo selectMenu(MenuInfo mi) {
		return null;
	}

	@Override
	public int insertMenu(MenuInfo mi) {
		return 0;
	}

	@Override
	public int deleteMenu(MenuInfo mi) {
		return 0;
	}

	@Override
	public int updateMenu(MenuInfo mi) {
		return 0;
	}


}
