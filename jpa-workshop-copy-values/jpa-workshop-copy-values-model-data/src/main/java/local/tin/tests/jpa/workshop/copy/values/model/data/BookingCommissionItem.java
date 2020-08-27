package local.tin.tests.jpa.workshop.copy.values.model.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author benitodarder
 */
@Entity
@Table(name = "BO_BOOKING_COMMISSION_ITEM")
@PrimaryKeyJoinColumn(name = "BO_BOOKING_COMMISSION_ITEMID")
public class BookingCommissionItem extends BookingItem {
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BO_BOOKING_PRODUCT_ITEMID", referencedColumnName = "BO_BOOKING_PRODUCT_ITEMID")
    private BookingProductItem bookingProductItem;        
    
    @Column(name = "TOTAL_COMMISION_AMOUNT_TCY")
    private Double totalCommissionTransaction;    
    
    
    @Column(name = "CURRENCY_CODE_TRANSACTION")
    private String currencyCodeTransaction;    

    @Column(name = "TOTAL_COMMISION_AMOUNT_LCY")
    private Double totalCommissionLocal;
    
    @Column(name = "CURRENCY_CODE_LOCAL")
    private String currencyCodeLocal;    


    @Column(name = "TOTAL_COMMISION_AMOUNT_SCY")
    private Double totalCommissionSystem;
    
    @Column(name = "CURRENCY_CODE_SYSTEM")
    private String currencyCodeSystem;      

    public BookingProductItem getBookingProductItem() {
        return bookingProductItem;
    }

    public void setBookingProductItem(BookingProductItem bookingProductItem) {
        this.bookingProductItem = bookingProductItem;
    }

    public Double getTotalCommissionTransaction() {
        return totalCommissionTransaction;
    }

    public void setTotalCommissionTransaction(Double totalCommissionTransaction) {
        this.totalCommissionTransaction = totalCommissionTransaction;
    }

    public String getCurrencyCodeTransaction() {
        return currencyCodeTransaction;
    }

    public void setCurrencyCodeTransaction(String currencyCodeTransaction) {
        this.currencyCodeTransaction = currencyCodeTransaction;
    }

    public Double getTotalCommissionLocal() {
        return totalCommissionLocal;
    }

    public void setTotalCommissionLocal(Double totalCommissionLocal) {
        this.totalCommissionLocal = totalCommissionLocal;
    }

    public String getCurrencyCodeLocal() {
        return currencyCodeLocal;
    }

    public void setCurrencyCodeLocal(String currencyCodeLocal) {
        this.currencyCodeLocal = currencyCodeLocal;
    }

    public Double getTotalCommissionSystem() {
        return totalCommissionSystem;
    }

    public void setTotalCommissionSystem(Double totalCommissionSystem) {
        this.totalCommissionSystem = totalCommissionSystem;
    }

    public String getCurrencyCodeSystem() {
        return currencyCodeSystem;
    }

    public void setCurrencyCodeSystem(String currencyCodeSystem) {
        this.currencyCodeSystem = currencyCodeSystem;
    }
    

    
}
