package com.iot.test.test;

import java.util.List;

import com.iot.test.DAO.MenuDAO;
import com.iot.test.DAO.impl.MenuDAOImpl;
import com.iot.test.vo.MenuInfo;

public class MenuTest {
	public static void main(String[] args) {
		MenuDAO mdao = new MenuDAOImpl();
		List<MenuInfo> menuList = mdao.selectMenuList();
		for(MenuInfo m : menuList) {
			System.out.println(m);
		}
	}
}
