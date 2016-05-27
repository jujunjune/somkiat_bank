/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package somkiat.bank.account.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Ponsak
 */
@Entity
@Table(name = "mst_account")
@NamedQueries({
    @NamedQuery(name = "MstAccount.findAll", query = "SELECT m FROM MstAccount m")})
public class MstAccount implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "account_no")
    private String accountNo;
    @Column(name = "account_name")
    private String accountName;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "account_balance")
    private BigDecimal accountBalance;
    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;

    public MstAccount() {
    }

    public MstAccount(String accountNo) {
        this.accountNo = accountNo;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountNo != null ? accountNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MstAccount)) {
            return false;
        }
        MstAccount other = (MstAccount) object;
        if ((this.accountNo == null && other.accountNo != null) || (this.accountNo != null && !this.accountNo.equals(other.accountNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "somkiat.bank.account.dto.MstAccount[ accountNo=" + accountNo + " ]";
    }
    
}
