package somkiat.bank.account.service;

import org.hibernate.Session;

import somkiat.bank.account.dto.TxnHistory;
import somkiat.bank.util.HibernateUtil;

public class TrxHistoryServiceImpl {

	public void createTrxHistory(TxnHistory obj){
		try{
			
			System.out.println("Begin");
			Session session = HibernateUtil.getSessionFactory().openSession();

			session.beginTransaction();
			
			session.save(obj);
			
			session.getTransaction().commit();

			System.out.println("Done");
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
