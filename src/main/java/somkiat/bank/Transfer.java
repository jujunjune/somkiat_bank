package somkiat.bank;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
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
import somkiat.bank.util.HibernateUtil;

public class Transfer extends HttpServlet{
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://107.170.105.104/somkiatbank";

	// Database credentials
	static final String USER = "user";
	static final String PASS = "euro2016";

	Connection conn = null;
	Statement stmt = null;
	/**
	 * 
	 */
	private static final long serialVersionUID = 4437947293029836364L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getAccount();
		MstAccount account = new MstAccount();
		account.setAccountBalance(new BigDecimal("1222"));
		account.setAccountName("Name");
		account.setAccountNo("123457890");
		account.setLastUpdate(new Date());
		req.setAttribute("account", account);
		req.getRequestDispatcher("/transfer.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String accountTo = req.getParameter("account-no-to");
		String amountTransfer = req.getParameter("amount-transfer");
		System.out.println(accountTo);
		System.out.println("Post");
		
		req.setAttribute("account", account);
		req.getRequestDispatcher("/transfer.jsp").forward(req, resp);
	}

	private MstAccount getAccount(){

		String sql = "FROM MstAccount as a where a.accountNo = '0000000001'";
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery(sql);
		
		List<MstAccount> account = query.list();
		session.close();
		System.out.println(account);
		return account.get(0);
		
	}
}
