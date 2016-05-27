package somkiat.bank.account.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Account implements Serializable{
	
	private static final long serialVersionUID = -6410816041268173750L;
	
	@Id
	@Column(name="account_id")
	private Integer accountId;
	
	@Column(name="account_code")
	private String accountCode;

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getAccountCode() {
		return accountCode;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

}
