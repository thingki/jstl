package com.iot.test.service.impl;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.iot.test.DAO.ClassDAO;
import com.iot.test.DAO.impl.ClassDAOImpl;
import com.iot.test.vo.ClassInfo;

public class ClassServiceImpl implements com.iot.test.service.ClassService {
	ClassDAO cdao = new ClassDAOImpl();
	Gson gson = new Gson();
	
	@Override
	public void getClassList(HttpServletRequest req) {
		ClassInfo ci = null;
		String json = req.getParameter("SerchCiName");
		String orderStr = (String) req.getParameter("order");
		String typeStr = (String) req.getParameter("type");

		if(json!=null) {
			ci=new ClassInfo();
			ci.setCiName(json);
			//ci = gson.fromJson(json, ClassInfo.class);
		}
		
		if(typeStr==null) {
			typeStr = "cino asc,ciname asc,cidesc asc";
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
		req.setAttribute("classList", cdao.selectClassList(ci, orderStr, typeStr));
		req.setAttribute("type", typeStr);
	}
	
	@Override
	public void getClass(HttpServletRequest req) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertClass(HttpServletRequest req) {
		// TODO Auto-generated method stub

	}

	@Override
	public int updateClass(HttpServletRequest req) {
		int result = cdao.updateClass(req);
		return result;
	}

	@Override
	public int deleteClass(HttpServletRequest req) {
		int result = cdao.deleteClass(req);
		return 0;
	}

}
