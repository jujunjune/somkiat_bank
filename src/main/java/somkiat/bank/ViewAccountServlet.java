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

public class ViewAccountServlet extends HttpServlet {

	private static final long serialVersionUID = 8745012609675674912L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("account", getAccountInformation("0000000001"));
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}

	private Account getAccountInformation(String accountNo) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		String sql = "select a.* from mst_account as a where a.account_no =:account_no";
		Query query = session.createSQLQuery(sql);
		query.setParameter("account_no", accountNo);
		List<Object> account = query.list();
		System.out.println(account.get(0));
		session.getTransaction().commit();
		return convertObjectToAccount(account.get(0));
	}

	Account convertObjectToAccount(Object objects) {
		Object[] objs = (Object[]) objects;
		Account account = new Account();
		account.setAccountNo(String.valueOf(objs[0]));
		account.setAccountName(String.valueOf(objs[1]));
		account.setAccountBalance(new BigDecimal(String.valueOf(objs[2])));
		account.setLastUpdate((Date) objs[3]);
		return account;
	}
}
