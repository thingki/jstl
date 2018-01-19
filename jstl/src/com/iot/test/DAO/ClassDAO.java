package com.iot.test.DAO;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.iot.test.vo.ClassInfo;

public interface ClassDAO {
	
	public List<ClassInfo> selectClassList(ClassInfo ci, String orderStr, String typeStr);
	public ClassInfo selectClass(ClassInfo ci);
	public int inserClass(ClassInfo ci);
	public int updateClass(HttpServletRequest req);
	public int deleteClass(HttpServletRequest req);

}
