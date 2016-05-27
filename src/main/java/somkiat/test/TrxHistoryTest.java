package somkiat.test;

import java.math.BigDecimal;
import java.util.Date;

import somkiat.bank.account.dto.TxnHistory;
import somkiat.bank.account.service.TrxHistoryServiceImpl;

public class TrxHistoryTest {

	public static void main(String[] args) {
		try{
			TrxHistoryServiceImpl his = new TrxHistoryServiceImpl();
			
			TxnHistory obj = new TxnHistory();
			obj.setAccountNoOwner("0100001");
			obj.setAccountNoTransfer("01111111");
			obj.setAmountTransfer(new BigDecimal(2.00));
			obj.setBalanceOwnerBeforeTransfer(new BigDecimal(3.00));
			obj.setTransactionType("IN");
			obj.setTxnDate(new Date());
			his.createTrxHistory(obj);
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
