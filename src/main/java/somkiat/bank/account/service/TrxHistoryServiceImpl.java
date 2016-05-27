package somkiat.bank.account.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import somkiat.bank.account.dto.TxnHistory;
import somkiat.bank.util.HibernateUtil;

public class TrxHistoryServiceImpl {
	private Session session = null;
	
	public void createFactory(){
		session = HibernateUtil.getSessionFactory().openSession();
	}
	
	public void createTrxHistory(TxnHistory obj){
		try{
			
			System.out.println(" createTrxHistory Begin");
			

			this.createFactory();
			session.beginTransaction();
			
			session.save(obj);
			
			session.getTransaction().commit();
			
			this.closeSession();

			System.out.println(" createTrxHistory Done");
			
		}catch(Exception e){
			try{
			this.closeSession();
			}catch(Exception ex){
				e.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	public void updateTrxHistory(TxnHistory obj){
		try{
			
			System.out.println(" updateTrxHistory Begin");
			
			this.createFactory();
			session.beginTransaction();
			
			session.update(obj);
			
			session.getTransaction().commit();
			
			this.closeSession();

			System.out.println(" updateTrxHistory Done");
			
		}catch(Exception e){
			try{
				this.closeSession();
				}catch(Exception ex){
					e.printStackTrace();
				}
			e.printStackTrace();
		}
	}
	
	public void deleteTrxHistory(TxnHistory obj){
		try{
			
			System.out.println(" deleteTrxHistory Begin");
			this.createFactory();
			session.beginTransaction();
			
			session.delete(obj);
			
			session.getTransaction().commit();
			
			this.closeSession();

			System.out.println(" deleteTrxHistory Done");
			
		}catch(Exception e){
			try{
				this.closeSession();
				}catch(Exception ex){
					e.printStackTrace();
				}
			e.printStackTrace();
		}
	}
	public List listTrxHistory(TxnHistory obj){
		Query query   = null;
		List  list = null;
		try{
			
			System.out.println(" listTrxHistory Begin");
			this.createFactory();
			query = session.createQuery("select p from TxnHistory p ");
			
			System.out.println(" ListTrxHistory Done");
			list = query.list();
			
			this.closeSession();
			return list;
			
		}catch(Exception e){
			try{
				this.closeSession();
				}catch(Exception ex){
					e.printStackTrace();
				}
			e.printStackTrace();
			return null;
		}finally{
			query = null;
			list = null;
		}
	}
	private void closeSession()throws Exception{
System.out.println("close session : "+session.isOpen());		
		if(session.isOpen())
			session.close();
		//HibernateUtil.closeSession();
	}
}
