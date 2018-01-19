package com.iot.test.service.impl;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.iot.test.DAO.MenuDAO;
import com.iot.test.DAO.impl.MenuDAOImpl;
import com.iot.test.service.MenuService;
import com.iot.test.vo.MenuInfo;

public class MenuServiceImpl implements MenuService {
	private MenuDAO mdao = new MenuDAOImpl();
	private Gson gson = new Gson();
	
	@Override
	public void getMenuList(HttpServletRequest req) {
		MenuInfo mi = null;
		String json = req.getParameter("SerchMenuName");
		if(json!=null) {
			mi = new MenuInfo();
			mi.setmName(json);
			
		}
		req.setAttribute("menuList", mdao.selectMenuList(mi));
	}

	@Override
	public void getMenu(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertMenu(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMenu(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateMenu(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMenuList(HttpServletRequest req) {
		req.setAttribute("menuList", mdao.selectMenuList());
	}

}
