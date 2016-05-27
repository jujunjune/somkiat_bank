package somkiat.bank;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import somkiat.bank.account.dto.TransactionOut;

/**
 * Servlet implementation class TransHistory
 */
// @WebServlet(name = "transHistory", description = "transaction history 30
// days", urlPatterns = { "/transHistory" })
public class TransHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://107.170.105.104/somkiatbank";

	// Database credentials
	static final String USER = "user";
	static final String PASS = "euro2016";

	Connection conn = null;
	Statement stmt = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TransHistory() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		ArrayList<TransactionOut> al =  new ArrayList<TransactionOut>();
		
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connected database successfully...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			String sql = "SELECT * FROM txn_history where transaction_type = 'OUT' and account_no_owner = '0000000001'";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				al.add(new TransactionOut(rs.getDate("txn_date").toString(),
									rs.getString("account_no_owner"),
									rs.getDouble("amount_transfer")));
				
				out.println("Date: " + rs.getDate("txn_date"));
				out.println("Account NO: " + rs.getString("account_no_owner"));
				out.println("Amount transfer: " + rs.getString("amount_transfer"));
			}

			rs.close();
		} catch (Exception se) {
			// Handle errors for JDBC
			se.printStackTrace();
		}

		req.setAttribute("account", "ponn");
		req.setAttribute("trans", al);
		req.getRequestDispatcher("transHistory.jsp").forward(req, resp);
		// resp.getWriter().append("Served at: ").append(req.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
