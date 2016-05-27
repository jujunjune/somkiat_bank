package somkiat.bank.account.object;

import java.util.List;

public class IncomeTransObject {

	private String accountName;
	private String accountNo;	
	private List<IncomeTranListObject>  listIncomeTran;

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public List<IncomeTranListObject> getListIncomeTran() {
		return listIncomeTran;
	}

	public void setListIncomeTran(List<IncomeTranListObject> listIncomeTran) {
		this.listIncomeTran = listIncomeTran;
	}

}
