package com.iot.test.DAO;

import java.util.List;

import com.iot.test.vo.MenuInfo;

public interface MenuDAO {
	
	public List<MenuInfo> selectMenuList(MenuInfo mi);
	public List<MenuInfo> selectMenuList();
	public MenuInfo selectMenu(MenuInfo mi);
	public int insertMenu(MenuInfo mi);
	public int deleteMenu(MenuInfo mi);
	public int updateMenu(MenuInfo mi);

}
