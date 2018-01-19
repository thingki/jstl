<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String root = request.getContextPath();
%>
<c:set var="root" value="<%=root%>"/>
<c:forEach items="${menuList}" var="menu">
<span><a href="${root}${menu.mUrl}"><input class="btn-lg" type="button" value="${menu.mName}"></a></span>
	
</c:forEach>
<br>
<script src="<%=root%>/ui/js/jquery-3.2.1.js"></script>
<script src="<%=root%>/ui/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="<%=root%>/ui/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=root%>/ui/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="<%=root%>/ui/css/common.css">

