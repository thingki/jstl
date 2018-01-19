package com.iot.test.service.impl;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.iot.test.DAO.UserDAO;
import com.iot.test.DAO.impl.UserDAOImpl;
import com.iot.test.service.UserService;
import com.iot.test.vo.ClassInfo;
import com.iot.test.vo.UserInfo;

public class UserServiceImpl implements UserService {
	UserDAO udao= new UserDAOImpl();
	Gson gs = new Gson();
	
	@Override
	public void getUserList(HttpServletRequest req) {
		UserInfo ui = null;
		String json = req.getParameter("SerchCiName");
		String orderStr = (String) req.getParameter("order");
		String typeStr = (String) req.getParameter("type");

		if(json!=null) {
			ui=new UserInfo();
			ui.setUiName(json);
			//ci = gson.fromJson(json, ClassInfo.class);
		}
		
		if(typeStr==null) {
			typeStr = "uiname asc,uiage asc,uiid asc, uipwd asc, cino asc, uiregdate asc, address asc";
		}
		
		if(orderStr!=null) {
			int pidex = typeStr.indexOf(orderStr);
			String typePStr = typeStr.substring(pidex);
			int lidex = typePStr.indexOf(",");
			
			if(lidex==-1) {
				typeStr = typeStr.replace(typePStr, "");
				typePStr = typePStr+",";
			}else {
				typePStr = typePStr.substring(0, lidex+1);
				typeStr = typeStr.replace(typePStr, "");
			}
			
			if(typePStr.indexOf("asc,")==-1) {
				typePStr = typePStr.replace("desc,", "asc,");
			}else {
				typePStr = typePStr.replace("asc,", "desc,");
			}		
			typeStr = typePStr + typeStr;
			if(typeStr.lastIndexOf(",")==typeStr.length()-1) {
				typeStr = typeStr.substring(0, typeStr.length()-1);
			}
		}		
		req.setAttribute("userList", udao.selectUserList(ui));//정렬안됨!!
		req.setAttribute("type", typeStr);
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
