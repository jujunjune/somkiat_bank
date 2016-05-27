package somkiat.bank.account.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import somkiat.bank.account.dto.TxnHistory;
import somkiat.bank.util.HibernateUtil;

public class TrxHistoryServiceImpl {
	private Session session = null;
	
	public TrxHistoryServiceImpl(){
		session = HibernateUtil.getSessionFactory().openSession();
	}
	
	public void createTrxHistory(TxnHistory obj){
		try{
			
			System.out.println(" createTrxHistory Begin");
			

			session.beginTransaction();
			
			session.save(obj);
			
			session.getTransaction().commit();
			
			session.close();

			System.out.println(" createTrxHistory Done");
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void updateTrxHistory(TxnHistory obj){
		try{
			
			System.out.println(" updateTrxHistory Begin");
			

			session.beginTransaction();
			
			session.update(obj);
			
			session.getTransaction().commit();
			
			session.close();

			System.out.println(" updateTrxHistory Done");
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void deleteTrxHistory(TxnHistory obj){
		try{
			
			System.out.println(" updateTrxHistory Begin");
			

			session.beginTransaction();
			
			session.delete(obj);
			
			session.getTransaction().commit();
			
			session.close();

			System.out.println(" updateTrxHistory Done");
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public List listTrxHistory(TxnHistory obj){
		Query             query   = null;
		try{
			
			System.out.println(" listTrxHistory Begin");
			

			session.beginTransaction();
			
			query = session.createQuery("select p from TxnHistory p ");
			
			
			System.out.println(" ListTrxHistory Done");
			return query.list();
			//session.getTransaction().commit();
			
			//session.close();

			
			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
