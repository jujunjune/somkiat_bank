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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "txn_history")
@NamedQueries({
    @NamedQuery(name = "TxnHistory.findAll", query = "SELECT t FROM TxnHistory t")})
public class TxnHistory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "txn_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date txnDate;
    @Column(name = "account_no_owner")
    private String accountNoOwner;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "balance_owner_before_transfer")
    private BigDecimal balanceOwnerBeforeTransfer;
    @Column(name = "account_no_transfer")
    private String accountNoTransfer;
    @Column(name = "amount_transfer")
    private BigDecimal amountTransfer;
    @Column(name = "transaction_type")
    private String transactionType;

    public TxnHistory() {
    }

    public TxnHistory(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTxnDate() {
        return txnDate;
    }

    public void setTxnDate(Date txnDate) {
        this.txnDate = txnDate;
    }

    public String getAccountNoOwner() {
        return accountNoOwner;
    }

    public void setAccountNoOwner(String accountNoOwner) {
        this.accountNoOwner = accountNoOwner;
    }

    public BigDecimal getBalanceOwnerBeforeTransfer() {
        return balanceOwnerBeforeTransfer;
    }

    public void setBalanceOwnerBeforeTransfer(BigDecimal balanceOwnerBeforeTransfer) {
        this.balanceOwnerBeforeTransfer = balanceOwnerBeforeTransfer;
    }

    public String getAccountNoTransfer() {
        return accountNoTransfer;
    }

    public void setAccountNoTransfer(String accountNoTransfer) {
        this.accountNoTransfer = accountNoTransfer;
    }

    public BigDecimal getAmountTransfer() {
        return amountTransfer;
    }

    public void setAmountTransfer(BigDecimal amountTransfer) {
        this.amountTransfer = amountTransfer;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TxnHistory)) {
            return false;
        }
        TxnHistory other = (TxnHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "somkiat.bank.account.dto.TxnHistory[ id=" + id + " ]";
    }
    
}
