<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/view/common/common.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UserList</title>
</head>
<body>
<script>
function getEl(){
	request.getElementBy
}

function checkValue(){
	var searchType = getEl("searchType").value.trim();
	var searchStr = getEl("searchStr").value.trim();
	
	if(searchType.length==0){
		alert("검색 종류를 선택하세요");
		getEl("searchType").focus();
	}
}
</script>


<h1>UserList yo man</h1><br>
<form onsubmit="return checkValue()">
<select name="SearchType" id="SearchType">
<option value="UiName" ${param.searchType eq "uiName" ? "selected":""}>이름</option>
<option value="UiId" ${param.searchType eq "uiId" ? "selected":""}>아이디</option>
<option value="UiAge" ${param.searchType eq "uiAge" ? "selected":""}>나이</option>
<option value="address" ${param.searchType eq "address" ? "selected":""}>주소</option>

</select>


<input type="text" placeholder="검색" name="SearchStr" value="<%=SearchStrValue%>">
<input type="submit" value="Serch" class="btn btn-primary">
</form>
<table class="table table-hover" border="1">
<tr>
<th>번호</th>
<th>이름</th><th>나이</th>
<th>아이디</th><th>비밀번호</th>
<th>주소</th><th>반번호</th>
</tr>
<c:forEach items="${userList}" var="ui">
<tr>
<th>${ui.uiNo}</th>
<th>${ui.uiName}</th>
<th>${ui.uiAge}</th>
<th>${ui.uiId}</th>
<th>${ui.uiPwd}</th>
<th>${ui.address}</th>
<th>${ui.ciNo}</th>
</tr>
</c:forEach>
</table>


</body>
</html>