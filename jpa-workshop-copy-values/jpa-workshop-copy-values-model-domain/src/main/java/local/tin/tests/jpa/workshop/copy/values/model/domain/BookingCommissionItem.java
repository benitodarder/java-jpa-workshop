package local.tin.tests.jpa.workshop.copy.values.model.domain;

/**
 *
 * @author benitodarder
 */
public class BookingCommissionItem extends BookingItem {
    
    private BookingProductItem bookingProductItem;        
    private Double totalCommissionTransaction;    
    private String currencyCodeTransaction;    
    private Double totalCommissionLocal;
    private String currencyCodeLocal;    
    private Double totalCommissionSystem;
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

    @Override
    public String toString() {
        return "BookingCommissionItem{" + "bookingProductItem=" + bookingProductItem + ", totalCommissionTransaction=" + totalCommissionTransaction + ", currencyCodeTransaction=" + currencyCodeTransaction + ", totalCommissionLocal=" + totalCommissionLocal + ", currencyCodeLocal=" + currencyCodeLocal + ", totalCommissionSystem=" + totalCommissionSystem + ", currencyCodeSystem=" + currencyCodeSystem + ", " + super.toString() + '}';
    }
    

    
}
