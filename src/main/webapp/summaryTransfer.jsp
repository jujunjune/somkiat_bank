<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="somkiat.bank.account.dto.MstAccount"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Somkiat Bank</title>
<link href="${contextPath}/css/bootstrap-3.3.6-dist/css/bootstrap.css"
	rel="stylesheet" />
</head>
<body>
<form method="get" action="${contextPath }">
	<div class="container-fluid">
		<div class="col-md-12 text-center">
			<label><h2 id="head-summary">โอนเงินสำเร็จ</h2></label>
		</div>
		<% MstAccount account = (MstAccount)request.getAttribute("account"); %>
		<div class="row">
			<label id="account-no" class="col-md-2 control-label">เลชที่บัญชี
			</label>
			<div class="col-md-2">
				<span><%=account.getAccountNo()%></span>
			</div>
			<div class="col-md-8"></div>
		</div>
		<div class="row">
			<label id="account-no" class="col-md-2 control-label">จำนวนเงิน (บาท)
			</label>
			<div class="col-md-2">
				<span><%=account.getAccountBalance()%></span>
			</div>
			<div class="col-md-8"></div>
		</div>
		<div class="row">
			<div class="col-md-2">
				<button type="submit" id="ok">OK</button>
			</div>
			<div class="col-md-10"></div>
		</div>
	</div>
</form>
</body>
</html>
