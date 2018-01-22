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
<script>
var GoPageObj=function(){
	this.move=function(page){
		if(!page){ //null undefind, fulse면 실행
			alert("잘못된 페이지 파라메터입니다.");
			return;
		}
		location.href="${root}/view"+page;
	}
}
var gpo=new GoPageObj();
function goPage(page){
	gpo.move(page);
}
</script>
<script src="<%=root%>/ui/js/jquery-3.2.1.js"></script>
<script src="<%=root%>/ui/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="<%=root%>/ui/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=root%>/ui/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="<%=root%>/ui/css/common.css">

