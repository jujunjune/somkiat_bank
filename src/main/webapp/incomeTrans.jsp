<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%> 
<%@ page import="somkiat.bank.account.object.IncomeTransObject,
				 somkiat.bank.account.object.IncomeTranListObject,
				 java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>หน้าจอแสดงรายละเอียดเงินเข้า</title>
</head>
<body>
	<%
		IncomeTransObject incomeTransObject	= (IncomeTransObject) request.getAttribute("dataObject");
	%>
	  <div>
			<label id="nameAcc" style="text-align:right">ชื่อบัญชี:</label>
			<label id="nameAccData" style="text-align:left"><%=incomeTransObject.getAccountName()%></label>
	  </div>  
	  <div>
			<label id="AccNo" style="text-align:right">เลขที่บัญชี</label>
			<label id="AccNoData" style="text-align:left"><%=incomeTransObject.getAccountNo()%></label>
	  </div>  
	  
	<div id="div_result">
		<table id="tb_result" border="1" style="overflow-y:auto;width:700px;">
              <tr bgcolor="#473636"  height="26px;">
				<th  style="text-align:center;" width="30px;"><B><font color="white">ลำดับ</font></B></th>
				<th  style="text-align:center;" width="150px;"><B><font color="white">วันที่</font></B></th>
				<th  style="text-align:left;"   width="150px;"><B><font color="white">วงเงิน</font></B></th> 
				<th  style="text-align:left;" 	width="10px;"><B><font color="white">บัญชีต้นทาง</font></B></th>
			</tr> 
		 
		     <%
				List<IncomeTranListObject>  list        =   incomeTransObject.getListIncomeTran();
		     	IncomeTranListObject	 	bean 		=   null;
				int 						rowNumber   =   0;
				 
				if(list.size()>0){
					for(int i=0;i<list.size();i++){
						bean = list.get(i);
						rowNumber = i+1; 
					
					%>
					 <tr>
						<td width="30px;"  align="center"><label id="seq"><%=rowNumber%></label></td>
						<td width="150px;" align="left"><label   id="tranDate"><%=bean.getTransDate()%></label></td>
						<td width="150px;" align="left"><label   id="tranAmount"><%=bean.getTarnAmount()%></label></td>
						<td width="100px;" align="left"><label   id="tranAcc"><%=bean.getTranAccount()%></label></td>
					</tr> 
			 <% 	} 
				}else{ %>
					<tr height="26px;"><td colspan="4"><b>ไม่พบข้อมูลที่ระบุ</b></td></tr>
			 <% } %>  
		</table> 
	</div> 
	  
</body>
</html>