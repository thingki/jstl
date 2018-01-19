<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/view/common/common.jsp" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ClassList</title>
</head>

<body>
<%
String SerchCiNameValue = request.getParameter("SerchCiName");
if(SerchCiNameValue==null){
	SerchCiNameValue="";
}

%>
<h1>CLASS LIST</h1><br>
<form>
<input type="text" placeholder="검색" name="SerchCiName" id="input" value="<%=SerchCiNameValue%>">
<input type="submit" value="Serch" class="btn btn-primary">
</form>
<table class="table table-hover" border="1">
<tr>
<th><a href="${root}/view/class/list?order=cino&type=${type}">번호</a></th>
<th><a href="${root}/view/class/list?order=ciname&type=${type}">이름</a></th>
<th><a href="${root}/view/class/list?order=cidesc&type=${type}">설명</a></th>
</tr>
<c:forEach items="${classList}" var="ci">
<tr>
<th>${ci.ciNo}</th>
<th>${ci.ciName}</th>
<th>${ci.ciDesc}</th>
</tr>
</c:forEach>
</table>
</body>
</html>
