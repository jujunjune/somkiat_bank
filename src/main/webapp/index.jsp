<%@page import="somkiat.bank.account.dto.Account"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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

		<div class="row">
			<div class="col-md-12">
				<div class="page-header" style="border-bottom: 1px solid #000;">
					<!--<h1>
					<font style="padding:15px; ">Bank of Somkiat</font>
				</h1>-->
					<img src="${contextPath}/images/logo.png">
				</div>
				<div class="row">
					<table width="100%" border="1px" cellspacing="0px"
						cellpadding="0px">
						<tr>
							<td width="20%" valign="top"
								style="background-color: #000; padding: 5px; color: #fff;">
								<div style="border-bottom: 1px solid #fff; padding: 10px;">
									<a href="" style="text-decoration: none; color: #fff;">หน้าแรก</a>
								</div>
								<div style="border-bottom: 1px solid #fff; padding: 10px;">
									<a href="" style="text-decoration: none; color: #fff;">โอนเงิน</a>
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
										<table>
											<tr>
												<td>เลขที่บัญชี :</td>
												<td id="account_no_label">${account.accountNo}</td>

											</tr>
											<tr>
												<td>ชื่อบัญชี :</td>
												<td id="account_name_label">${account.accountName}</td>
											</tr>
											<tr>
												<td>ยอดเงินคงเหลือ :</td>
												<td id="account_balance_label"><fmt:formatNumber
														type="number" pattern="#,###.00"
														value="${account.accountBalance}" /></td>
											</tr>
											<tr>
												<td>ปรับปรุงเมื่อ :</td>
												<td id="last_update_label"><fmt:formatDate
														pattern="dd/MM/yyyy hh:mm" value="${account.lastUpdate}" /></td>
											</tr>
										</table>
									</div>
								</div>
							</td>
						</tr>
					</table>

				</div>
			</div>
		</div>

	</div>

	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/scripts.js"></script>
</body>
</html>
