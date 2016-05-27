package somkiat.bank;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;

import somkiat.bank.account.dto.Account;
import somkiat.bank.util.HibernateUtil;

public class Transfer extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4437947293029836364L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getAccount();
		Account account = new Account();
		account.setAccountBalance(new BigDecimal("1222"));
		account.setAccountName("Name");
		account.setAccountNo("123457890");
		account.setLastUpdate(new Date());
		req.setAttribute("account", account);
		req.getRequestDispatcher("/transfer.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		super.doPost(req, resp);
	}

	private Account getAccount(){
		String sql = "FROM somkiatbank.mst_account as a where a.account_no = '0000000001'";
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Query query = session.createQuery(sql);
		
		List<Account> account = query.list();
		System.out.println(account);
		return account.get(0);
		
	}
}
