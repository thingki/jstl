package com.iot.test.service;

import javax.servlet.http.HttpServletRequest;

public interface ClassService {
	
	public void getClassList(HttpServletRequest req);
	public void getClass(HttpServletRequest req);
	public int insertClass(HttpServletRequest req);
	public int updateClass(HttpServletRequest req);
	public int deleteClass(HttpServletRequest req);
	

}
