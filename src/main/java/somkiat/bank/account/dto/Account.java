package somkiat.bank.account.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "mst_account")
public class Account implements Serializable {

	private static final long serialVersionUID = -6410816041268173750L;

	@Id
	@Column(name = "account_no", length = 20)
	private String accountNo;

	@Column(name = "account_name", length = 100)
	private String accountName;

	@Column(name = "account_balance")
	private BigDecimal accountBalance;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update")
	private Date lastUpdate;

	public String getDisplayAccountNo() {
		return accountNo.substring(0, 3) + "-" + accountNo.substring(3, 4) + "-" + accountNo.substring(4, 9) + "-"
				+ accountNo.substring(9, 10);
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public BigDecimal getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

}
