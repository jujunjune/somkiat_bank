<%@page import="somkiat.bank.account.dto.Account"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
				<div class="page-header">
					<h1>Bank of Somkiat</h1>
				</div>
				<div class="row">
					<table width="100%">
						<tr>
							<td width="20%" valign="top">
								<div>
									<a>หน้าแรก</a>
								</div>
								<div>
									<a>โอนเงิน</a>
								</div>
								<div>
									<a>รายการเข้า</a>
									<ul>

										<li><a>เงินเข้า</a></li>
										<li><a>เงินออก</a></li>
									</ul>
								</div>
							</td>
							<td valign="top">
								<div class="container-fluid">
									<h2>Hello World!</h2>
									<a href="${contextPath}/viewTransaction">View Transaction</a> <span>${account.accountNo}</span>
									<span>${account.accountName}</span>

									<c:out value="${account.accountName}"></c:out>
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
