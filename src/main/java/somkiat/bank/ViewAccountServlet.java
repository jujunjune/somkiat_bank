package somkiat.bank;

import java.io.IOException;
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

		String sql = "from Account where accountNo =:account_no";
		Query query = session.createQuery(sql);
		query.setParameter("account_no", accountNo);
		List<Account> account = query.list();

		return account.get(0);
	}
}
