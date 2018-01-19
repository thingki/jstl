package com.iot.test.service.impl;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.iot.test.DAO.UserDAO;
import com.iot.test.DAO.impl.UserDAOImpl;
import com.iot.test.service.UserService;
import com.iot.test.vo.UserInfo;

public class UserServiceImpl implements UserService {
	UserDAO udao= new UserDAOImpl();
	Gson gs = new Gson();
	
	@Override
	public void getUserList(HttpServletRequest req) {
		UserInfo ui = null;
		String SearchType = req.getParameter("SearchType");
		if(SearchType!=null) {
			ui=new UserInfo();
		}
			ui.setSearchType(searchType);
			if(SearchType.equals("uiName")) {
				ui.setUiName(uiName);
			}else if(searchType.)
			//ui=gs.fromJson(json, UserInfo.class);
			
		}
		req.setAttribute("userList", udao.selectUserList(ui));
	}

	@Override
	public void getUser(HttpServletRequest req) {
		// TODO Auto-generated method stub

	}

	@Override
	public void inserUser(HttpServletRequest req) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUser(HttpServletRequest req) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(HttpServletRequest req) {
		// TODO Auto-generated method stub

	}

}
