package somkiat.bank.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import somkiat.bank.account.dto.TxnHistory;
import somkiat.bank.util.HibernateUtil;

public class TransactionHistoryDAO
{
	public List<TxnHistory> list ( String type, Date fromDate, Date toDate )
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		String hql = "from TxnHistory txn" +
					 " where txn.txnDate >= :fromDate and txn.txnDate <= :toDate and" +
					 "       txn.transactionType = :type";
		Query query = session.createQuery( hql );
		query.setDate("fromDate", fromDate);
		query.setDate("toDate", toDate);
		query.setString("type", type);
		
		List<TxnHistory> list = (List<TxnHistory>)query.list();
		HibernateUtil.closeSession();

		return list;
	}
}
