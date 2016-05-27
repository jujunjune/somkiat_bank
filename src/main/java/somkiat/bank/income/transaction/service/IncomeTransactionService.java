package somkiat.bank.income.transaction.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import somkiat.bank.account.dto.TxnHistory;
import somkiat.bank.dao.TransactionHistoryDAO;
import somkiat.bank.vo.IncomeTransactionVO;

public class IncomeTransactionService
{
	private static String   INCOME_TRANSACTION_TYPE = "IN";
	
	
	private TransactionHistoryDAO   transactionHistoryDAO;
	
	public IncomeTransactionService ( )
	{
		transactionHistoryDAO = new TransactionHistoryDAO();
	}
	
	
	public List<IncomeTransactionVO> inquiryIncomeTransaction ( )
	 {
		List<IncomeTransactionVO>  vos = new ArrayList<IncomeTransactionVO>();
		
		Calendar cal = Calendar.getInstance(Locale.US);
		cal.add(Calendar.DAY_OF_MONTH, -90);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		
		Date fromDate = cal.getTime();
		Date toDate = new Date();


		try
		 {
			int no = 1;
			List<TxnHistory> transactions = transactionHistoryDAO.list(INCOME_TRANSACTION_TYPE, fromDate, toDate);
			for ( TxnHistory transaction : transactions )
			{
				  IncomeTransactionVO vo = createIncomeTransactionVO( no, transaction );
				  
				  vos.add( vo );
				  no++;
			}
			
		 }
		catch ( Throwable thw )
		 {
			thw.printStackTrace();
		 }
		
		return vos;
		
	 }
	
	
	private IncomeTransactionVO createIncomeTransactionVO ( int no, TxnHistory transaction )
	{
		IncomeTransactionVO vo = new IncomeTransactionVO();
		vo.setNo(String.valueOf(no));
		vo.setTransactionDate( "" );
		vo.setAmountTransfer( "" );
		vo.setAccountNoTransfer("");
		
		return vo;
	}
	
	
	public static void println ( IncomeTransactionVO vo )
	{
		System.out.println( "no: " + vo.getNo() + ", date: " + vo.getTransactionDate() + ", amount: " + vo.getAmountTransfer() + ", src account: " + vo.getAccountNoTransfer() );
	}
	
	
	public static void main ( String [] args )
	{
		IncomeTransactionService service = new IncomeTransactionService();
		
		List<IncomeTransactionVO> vos = service.inquiryIncomeTransaction();
		
		for ( IncomeTransactionVO vo : vos )
		{
			println(vo);
		}
	}
}
