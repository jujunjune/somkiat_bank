<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="somkiat.bank.account.dto.MstAccount" %>
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
	<div class="container-fluid">
	<div class="col-md-12 text-center">
		<label><h2>Money transfer (Same bank)</h2></label>
	</div>
 	<% MstAccount account = (MstAccount)request.getAttribute("account"); %>
		<form action="${contextPath}/transfer" class="form-horizontal" method="post">
			<div class="form-group">
				<label id="account-no" class="col-md-2 control-label">เลขที่บัญชี: </label> 
				<span class="col-md-2" ><%=account.getAccountNo() %></span>
				<div class="col-md-8"></div>
			</div>
			<div class="form-group">
				<label id="account-no" class="col-md-2 control-label">ยอดเงินคงเหลือ: </label> 
				<span class="col-md-2"><%=account.getAccountBalance() %></span>
				<div class="col-md-10"></div>
			</div>
			<div class="form-group">
				<label id="account-no" class="col-md-2 control-label">เลขที่บัญชีปลายทาง: </label> 
				<div class="col-md-2">
					<input type="text" name="account-no-to" class="col-md-2 form-control" id="to-transafer-no-txt"/>					
				</div>
				<div class="col-md-8"></div>
			</div>
			<div class="form-group">
				<label id="account-no" class="col-md-2 control-label">จำนวนเงิน: </label> 
				<div class="col-md-2">
					<input type="text" name="amount-transfer" class="col-md-2 form-control" id="amount-txt"/>					
				</div>
				<div class="col-md-8"></div>
			</div>
			<div class="form-group">
				<div class="col-md-4 text-center">
					<button type="submit" id="transfer-btn" class="btn btn-success">โอน</button>
					<button type="button" id="cancel-btn" class="btn btn-danger">ยกเลิก</button>
				</div>
				<div class="col-md-8"></div>
			</div>
		</form>
	</div>

</body>
</html>
