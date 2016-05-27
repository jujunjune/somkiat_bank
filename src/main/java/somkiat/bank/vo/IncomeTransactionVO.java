package somkiat.bank.vo;


public class IncomeTransactionVO
{
	private String no;
    private String transactionDate;
    private String accountNoOwner;
    private String accountNoTransfer;
    private String amountTransfer;
    
    
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getAccountNoOwner() {
		return accountNoOwner;
	}
	public void setAccountNoOwner(String accountNoOwner) {
		this.accountNoOwner = accountNoOwner;
	}
	public String getAccountNoTransfer() {
		return accountNoTransfer;
	}
	public void setAccountNoTransfer(String accountNoTransfer) {
		this.accountNoTransfer = accountNoTransfer;
	}
	public String getAmountTransfer() {
		return amountTransfer;
	}
	public void setAmountTransfer(String amountTransfer) {
		this.amountTransfer = amountTransfer;
	}
    
 
}
