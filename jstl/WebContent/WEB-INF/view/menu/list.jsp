<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/view/common/common.jsp" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MENU LIST</title>
</head>
<body>
<%
String SerchMenuNameValue = request.getParameter("SerchMenuName");
if(SerchMenuNameValue==null){
	SerchMenuNameValue="";
}
%>
<h1>Menu List</h1><br>
<form>
<input type="text" placeholder="검색" name="SerchMenuName" value="<%=SerchMenuNameValue%>">
<input class="btn btn-primary" type="submit" value="Serch" >
</form>

<table class="table table-hover" border="1">
<tr>
<th>번호</th>
<th>이름</th>
<th>URL</th>
<th>설명</th>
</tr>
<c:forEach items="${menuList}" var="menu">
<tr>
<th>${menu.mNum}</th>
<th>${menu.mName}</th>
<th>${menu.mUrl}</th>
<th>${menu.mDesc}</th>
</tr>
</c:forEach>
</table>
</body>
</html>