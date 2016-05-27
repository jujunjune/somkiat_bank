package somkiat.bank;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;

import somkiat.bank.account.dto.MstAccount;
import somkiat.bank.account.dto.TxnHistory;
import somkiat.bank.account.service.TrxHistoryServiceImpl;
import somkiat.bank.util.HibernateUtil;

public class Transfer extends HttpServlet {
	private Session session = null;


	private static final long serialVersionUID = 4437947293029836364L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MstAccount account = getAccount("0000000001");
		req.setAttribute("account", account);
		req.getRequestDispatcher("/transfer.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TrxHistoryServiceImpl trxHistory = new TrxHistoryServiceImpl();
		MstAccount accountOwn = getAccount("0000000001");
		
		String accountTo = req.getParameter("accountnoto");
		String amountTransfer = req.getParameter("amount-transfer");
		
		MstAccount accountTransferTo = getAccount("0000000002");
		
		BigDecimal amountTran = new BigDecimal(amountTransfer);

		TxnHistory txnHistory = new TxnHistory();
		txnHistory.setAccountNoOwner("0000000001");
		txnHistory.setAccountNoTransfer(accountTo);
		txnHistory.setAmountTransfer(amountTran);
		txnHistory.setBalanceOwnerBeforeTransfer(accountOwn.getAccountBalance());
		txnHistory.setTransactionType("OUT");
		txnHistory.setTxnDate(new Date());
		trxHistory.createTrxHistory(txnHistory);

		BigDecimal totalAmountOwn = accountOwn.getAccountBalance();
		totalAmountOwn = totalAmountOwn.subtract(amountTran);
		accountOwn.setAccountBalance(totalAmountOwn);
		
		BigDecimal totalAmountTo = accountTransferTo.getAccountBalance();
		totalAmountTo = totalAmountTo.add(amountTran);
		accountTransferTo.setAccountBalance(totalAmountTo);
		accountTransferTo.setLastUpdate(new Date());
		
		updateAccount(accountTransferTo);
		updateAccount(accountOwn);
		
		accountOwn = getAccount("0000000001");
		req.setAttribute("account", accountOwn);
		req.getRequestDispatcher("/summaryTransfer.jsp").forward(req, resp);
	}

	private MstAccount getAccount(String accountNo) {
		System.out.println(accountNo);
		String sql = "FROM MstAccount as a where a.accountNo = '" +accountNo+ "'";
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery(sql);

		List<MstAccount> account = query.list();
		session.close();
		System.out.println(account);
		return account.get(0);
	}

	private void updateAccount(MstAccount obj) {
		session = HibernateUtil.getSessionFactory().openSession();
		try {

			System.out.println(" updateMaster Account Begin");

			session.beginTransaction();

			session.update(obj);

			session.getTransaction().commit();

			session.close();

			System.out.println(" updateMaster Account Done");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
