
package business;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author acmor
 */
@Entity
@Table(name="tblpurchases")
public class Purchase {
    @Id
    @Column(name="ID")
    private long pid;
    @Column(name="MemID")
    private String memid;
    @Column(name="PurchaseDt")
    @Temporal(TemporalType.DATE)
    private Date purchdt; 
    @Column(name="TransType")
    private String purchtype;
    @Column(name="TransCd")
    private String transcd; 
    @Column(name="Amount")
    private double amt;
    
    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="TransCd", insertable=false, updatable=false)
    private PCodes pcodes;
    
    public Purchase() {
        this.memid = "";
        this.purchdt = null;
        this.purchtype = "";
        this.transcd = "";
        this.amt = 0;
        this.pid = 0;
    }
    
    public long getPid() {
        return this.pid;
    }
    
    public void setPid(long pid) {
        this.pid = pid;
    }

    public String getMemid() {
        return memid;
    }

    public void setMemid(String memid) {
        this.memid = memid;
    }

    public Date getPurchdt() {
        return purchdt;
    }

    public void setPurchdt(Date purchdt) {
        this.purchdt = purchdt;
    }
    
    public String getPurchdtS () {
        return new SimpleDateFormat("MM-dd-yyyy").format(this.purchdt);
    }

    public String getPurchtype() {
        return purchtype;
    }

    public void setPurchtype(String purchtype) {
        this.purchtype = purchtype;
    }

    public String getTranscd() {
        return transcd;
    }

    public void setTranscd(String transcd) {
        this.transcd = transcd;
    }

    public double getAmt() {
        return amt;
    }

    public void setAmt(double amt) {
        this.amt = amt;
    }
    
    public String getAmtS () {
    NumberFormat curr = NumberFormat.getCurrencyInstance();
    return curr.format(this.amt);
}
    public String getTransdesc() {
        return pcodes.getTransdesc();
    }
}
