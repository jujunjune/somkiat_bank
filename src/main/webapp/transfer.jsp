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
	<div class="container-fluid">
		<div class="col-md-12">
			<div class="page-header" style="border-bottom: 1px solid #000;">
				<!--<h1>
					<font style="padding:15px; ">Bank of Somkiat</font>
				</h1>-->
				<img src="${contextPath}/images/logo.png">
			</div>
			<div class="row">
				<table width="100%" border="1px" cellspacing="0px" cellpadding="0px">
					<tr>
						<td width="20%" valign="top"
							style="background-color: #000; padding: 5px; color: #fff;">
							<div style="border-bottom: 1px solid #fff; padding: 10px;">
								<a href="" style="text-decoration: none; color: #fff;">หน้าแรก</a>
							</div>
							<div style="border-bottom: 1px solid #fff; padding: 10px;">
								<a href="${contextPath}/transfer" style="text-decoration: none; color: #fff;">โอนเงิน</a>
							</div>
							<div style="border-bottom: 1px solid #fff; padding: 10px;">
								<a href="" style="text-decoration: none; color: #fff;">รายการเข้า</a>
							</div>
							<div
								style="border-bottom: 1px solid #fff; padding: 10px 10px 10px 40px;">
								<a href="" style="text-decoration: none; color: #fff;">เงินเข้า</a>
							</div>
							<div style="padding: 10px 10px 10px 40px;">
								<a href="" style="text-decoration: none; color: #fff;">เงินออก</a>
							</div>
						</td>
						<td valign="top">
							<div style="padding: 20px;">
								<div class="container-fluid">
									<div class="col-md-12 text-center">
										<label><h2>Money transfer (Same bank)</h2></label>
									</div>
									<%
										MstAccount account = (MstAccount) request.getAttribute("account");
									%>
									<form action="${contextPath}/transfer" class="form-horizontal"
										method="post">
										<div class="form-group">
											<label id="account-no" class="col-md-2 control-label">เลขที่บัญชี:
											</label> <span class="col-md-2"><%=account.getAccountNo()%></span>
											<div class="col-md-8"></div>
										</div>
										<div class="form-group">
											<label id="account-no" class="col-md-2 control-label">ยอดเงินคงเหลือ:
											</label> <span class="col-md-2"><%=account.getAccountBalance()%></span>
											<div class="col-md-10"></div>
										</div>
										<div class="form-group">
											<label id="account-no" class="col-md-2 control-label">เลขที่บัญชีปลายทาง:
											</label>
											<div class="col-md-2">
												<input type="text" name="accountnoto"
													class="col-md-2 form-control" id="to-transafer-no-txt" />
											</div>
											<div class="col-md-8"></div>
										</div>
										<div class="form-group">
											<label id="account-no" class="col-md-2 control-label">จำนวนเงิน:
											</label>
											<div class="col-md-2">
												<input type="text" name="amount-transfer"
													class="col-md-2 form-control" id="amount-txt" />
											</div>
											<div class="col-md-8"></div>
										</div>
										<div class="form-group">
											<div class="col-md-4 text-center">
												<button type="submit" id="transfer-btn"
													class="btn btn-success">โอน</button>
												<button type="button" id="cancel-btn" class="btn btn-danger">ยกเลิก</button>
											</div>
											<div class="col-md-8"></div>
										</div>
									</form>
								</div>
							</div>
							</div>
						</td>
					</tr>
				</table>

			</div>
		</div>
</body>
</html>
