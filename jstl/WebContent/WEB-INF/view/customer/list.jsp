<%@page import="java.util.ArrayList"%>
<%@page import="com.iot.test.vo.Customer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/view/common/common.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer List</title>
</head>
<%
String SerchCustomerNameValue = request.getParameter("SerchCustomerName");
if(SerchCustomerNameValue==null){
	SerchCustomerNameValue="";
}

%>
<body Style="background: black; color: white">
	<h1>Customer List</h1>
	<br>
	<form Style="color: black">
		<input type="text" placeholder="검색" name="SerchCustomerName" id="input" value="<%=SerchCustomerNameValue%>">
		<input type="submit" value="Serch" class="btn btn-primary">
	</form>

	<table class="table table-hover" border="1" Style="color: black">
		<tr Style="background: #cccccc">
			<th class='text-center'><a
				href="${root}/view/customer/list?order=customerid&type=${type}">Customer
					ID</a></th>
			<th class='text-center'><a
				href="${root}/view/customer/list?order=customername&type=${type}">Customer
					Name</a></th>
			<th class='text-center'><a
				href="${root}/view/customer/list?order=city&type=${type}">City</a></th>
			<th class='text-center'><a
				href="${root}/view/customer/list?order=country&type=${type}">Country</a></th>
			<th class="text-center" data-field="BTN"><em
				class="glyphicon glyphicon-wrench"></em></th>
		</tr>
		<c:if test="${customerList eq null}">
			<tr>
				<td colspan="4" align="center">고객리스트가 없습니다</td>
			</tr>
		</c:if>
		<c:forEach items="${customerList}" var="customer">
		<form action="${root}/view/customer/upanddel">
			<tr>
				<th class='text-center' Style="color: white">${customer.customerId}</th>
				<th class='text-center'><input type ='text' name="customerName" value="${customer.customerName}" class='text-center'></th>
				<th class='text-center'><input type ='text' name="city" value="${customer.city}" class='text-center'></th>
				<th class='text-center'><input type ='text' name="country" value="${customer.country}" class='text-center'></th>
				<th class='text-center'>
				<button class="btn btn-default" name="updateKey" value="${customer.customerId}"><em class="glyphicon glyphicon-scissors"></em></button>
				<button class="btn btn-danger" name="deleteKey" value="${customer.customerId}"><em class="glyphicon glyphicon-trash"></em></button>
				</th>
			</tr>
		</form>
		</c:forEach>
	</table>

	<table class="table table-hover">
		<thead>
			<tr>
				<th class='text-center'>Customer Name</th>
				<td><input type="text" id="customerName" name="customerName"
					class="form-control" placeholder="이름" autofocus></td>

				<th class='text-center'>City</th>
				<td><input type="text" id="city" name="city"
					class="form-control" placeholder="도시"></td>


				<th class='text-center'>Country</th>
				<td><input type="text" id="country" name="country"
					class="form-control" placeholder="나라"></td>
			</tr>
			<tr>
				<td colspan="6"><input
					class="btn btn-lg btn-secondary btn-block" type="button"
					id="Insert" value="Insert" onclick="Insert()"></td>
			</tr>
		</tbody>
	</table>
</body>
<script>
function Insert(){
	var customerName = $("#customerName").val().trim();
	var city = $("#city").val().trim();
	var country = $("#country").val().trim();
	
	var param= {customerName:customerName, city:city, country:country};
	param = "param=" + JSON.stringify(param);
	$.ajax({
		url : '<%=root%>/customer/insert',
		type : 'post',
		data : param,
		success:function(res){
			var obj = JSON.parse(res);
			alert(obj.msg);
			if(obj.result=="ok"){
				location.href="/view/customer/list";
			}
		},
		error:function(xhr,status,error){		
		}		
	})
}

function deleteClass(){
	var isUpdate = confirm("Update??");
	int num = ${customer.customerId};
	alert(num);
}
</script>
</html>