<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/view/common/common.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UserList</title>
</head>
<body>

	<h1>UserList yo man</h1>
	<br>
	<form>
		<select name="SearchType" id="SearchType">
			<option value="UiName"
				${param.searchType eq "uiName" ? "selected":""}>이름</option>
			<option value="UiId" ${param.searchType eq "uiId" ? "selected":""}>아이디</option>
			<option value="UiAge" ${param.searchType eq "uiAge" ? "selected":""}>나이</option>
			<option value="address"
				${param.searchType eq "address" ? "selected":""}>주소</option>

		</select>



	</form>
	<table class="table table-hover" border="1">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>나이</th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>주소</th>
			<th>반번호</th>
		</tr>

		<c:forEach items="${userList}" var="ui">
			<tr onclick="GoPage(view)">
				<th>${ui.uiNo}</th>
				<th>${ui.uiName}</th>
				<th>${ui.uiAge}</th>
				<th>${ui.uiId}</th>
				<th>${ui.uiPwd}</th>
				<th>${ui.address}</th>
				<th>${ui.ciNo}</th>
			</tr>
			
		</c:forEach>
		<tr>
			<th colspan="7"><input type="button" value="insert"></th></tr>
	</table>


</body>
</html>