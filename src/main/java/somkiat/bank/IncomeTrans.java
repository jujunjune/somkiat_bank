package somkiat.bank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.fabric.xmlrpc.base.Array;

import somkiat.bank.account.object.IncomeTranListObject;
import somkiat.bank.account.object.IncomeTransObject;

public class IncomeTrans extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4437947293029836364L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		doProcess(req, resp);
		req.getRequestDispatcher("/incomeTrans.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		doProcess(req, resp);
		req.getRequestDispatcher("/incomeTrans.jsp").forward(req, resp);
	}

	private void doProcess(HttpServletRequest req, HttpServletResponse resp) {
		IncomeTransObject 	 		incomeTransObject = new IncomeTransObject();
		List<IncomeTranListObject>  listIncomeTran	  = new ArrayList<IncomeTranListObject>();
		IncomeTranListObject incomeTranListObject;
		
		incomeTransObject.setAccountName("สมเกรียติ ทดสอบการทำงาน");
		incomeTransObject.setAccountNo("000-0-00000-1");
		
		//รายการที่ 1
		incomeTranListObject = new IncomeTranListObject();
		incomeTranListObject.setTransDate("25 พฤษภาคม 2559");
		incomeTranListObject.setTarnAmount("50,000.00");
		incomeTranListObject.setTranAccount("000-0-00000-2");
		listIncomeTran.add(incomeTranListObject);
		
		//รายการที่ 2
		incomeTranListObject = new IncomeTranListObject();
		incomeTranListObject.setTransDate("25 เมษายน 2559");
		incomeTranListObject.setTarnAmount("60,000.00");
		incomeTranListObject.setTranAccount("000-0-00000-2");
		listIncomeTran.add(incomeTranListObject);
		
		//รายการที่ 3
		incomeTranListObject = new IncomeTranListObject();
		incomeTranListObject.setTransDate("25 มีนาคม 2559");
		incomeTranListObject.setTarnAmount("50,000.00");
		incomeTranListObject.setTranAccount("000-0-00000-2");
		listIncomeTran.add(incomeTranListObject);

		incomeTransObject.setListIncomeTran(listIncomeTran);

		req.setAttribute("dataObject", incomeTransObject);
	}
}
