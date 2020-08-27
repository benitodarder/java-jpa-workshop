package local.tin.tests.jpa.workshop.copy.values.model.domain;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author benitodarder
 */
public class BookingProductItem extends BookingItem {
    
    private Integer booking;
    private Integer productId;
    private Integer sellerCompanyId;
    private String productName;
    private String bookingProductReference;
    private Date invoiceDate;
    private Boolean sendNewUserBookingNotification;
    private Integer cancellationPolicyRuleId;
    private Double cancelAmountTransaction;
    private String currencyCodeTransaction;
    private Integer taxId;
    private Double totalAmountTransaction;    
    private Double totalAmountLocal;
    private String currencyCodeLocal;    
    private Double totalAmountSystem;
    private String currencyCodeSystem;       
    private Collection<BookingCommissionItem> bookingCommissionItems;    
    private Double totalCommissionTransaction;    
    private Double totalCommissionLocal;
    private Double totalCommissionSystem;
    
    public Integer getBooking() {
        return booking;
    }

    public void setBooking(Integer booking) {
        this.booking = booking;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getSellerCompanyId() {
        return sellerCompanyId;
    }

    public void setSellerCompanyId(Integer sellerCompanyId) {
        this.sellerCompanyId = sellerCompanyId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBookingProductReference() {
        return bookingProductReference;
    }

    public void setBookingProductReference(String bookingProductReference) {
        this.bookingProductReference = bookingProductReference;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Boolean getSendNewUserBookingNotification() {
        return sendNewUserBookingNotification;
    }

    public void setSendNewUserBookingNotification(Boolean sendNewUserBookingNotification) {
        this.sendNewUserBookingNotification = sendNewUserBookingNotification;
    }

    public Integer getCancellationPolicyRuleId() {
        return cancellationPolicyRuleId;
    }

    public void setCancellationPolicyRuleId(Integer cancellationPolicyRuleId) {
        this.cancellationPolicyRuleId = cancellationPolicyRuleId;
    }

    public Double getCancelAmountTransaction() {
        return cancelAmountTransaction;
    }

    public void setCancelAmountTransaction(Double cancelAmountTransaction) {
        this.cancelAmountTransaction = cancelAmountTransaction;
    }

    public String getCurrencyCodeTransaction() {
        return currencyCodeTransaction;
    }

    public void setCurrencyCodeTransaction(String currencyCodeTransaction) {
        this.currencyCodeTransaction = currencyCodeTransaction;
    }

    public Integer getTaxId() {
        return taxId;
    }

    public void setTaxId(Integer taxId) {
        this.taxId = taxId;
    }

    public Double getTotalAmountTransaction() {
        return totalAmountTransaction;
    }

    public void setTotalAmountTransaction(Double totalAmountTransaction) {
        this.totalAmountTransaction = totalAmountTransaction;
    }

    public Double getTotalAmountLocal() {
        return totalAmountLocal;
    }

    public void setTotalAmountLocal(Double totalAmountLocal) {
        this.totalAmountLocal = totalAmountLocal;
    }

    public String getCurrencyCodeLocal() {
        return currencyCodeLocal;
    }

    public void setCurrencyCodeLocal(String currencyCodeLocal) {
        this.currencyCodeLocal = currencyCodeLocal;
    }

    public Double getTotalAmountSystem() {
        return totalAmountSystem;
    }

    public void setTotalAmountSystem(Double totalAmountSystem) {
        this.totalAmountSystem = totalAmountSystem;
    }

    public String getCurrencyCodeSystem() {
        return currencyCodeSystem;
    }

    public void setCurrencyCodeSystem(String currencyCodeSystem) {
        this.currencyCodeSystem = currencyCodeSystem;
    }

    public Collection<BookingCommissionItem> getBookingCommissionItems() {
        if (bookingCommissionItems == null) {
            bookingCommissionItems = new HashSet<>();
        }
        return bookingCommissionItems;
    }

    public void setBookingCommissionItems(Set<BookingCommissionItem> bookingCommissionItems) {
        this.bookingCommissionItems = bookingCommissionItems;
    }    

    public Double getTotalCommissionTransaction() {
        return totalCommissionTransaction;
    }

    public void setTotalCommissionTransaction(Double totalCommissionTransaction) {
        this.totalCommissionTransaction = totalCommissionTransaction;
    }

    public Double getTotalCommissionLocal() {
        return totalCommissionLocal;
    }

    public void setTotalCommissionLocal(Double totalCommissionLocal) {
        this.totalCommissionLocal = totalCommissionLocal;
    }

    public Double getTotalCommissionSystem() {
        return totalCommissionSystem;
    }

    public void setTotalCommissionSystem(Double totalCommissionSystem) {
        this.totalCommissionSystem = totalCommissionSystem;
    }

    @Override
    public String toString() {
        return "BookingProductItem{" + "booking=" + booking + ", productId=" + productId + ", sellerCompanyId=" + sellerCompanyId + ", productName=" + productName + ", bookingProductReference=" + bookingProductReference + ", invoiceDate=" + invoiceDate + ", sendNewUserBookingNotification=" + sendNewUserBookingNotification + ", cancellationPolicyRuleId=" + cancellationPolicyRuleId + ", cancelAmountTransaction=" + cancelAmountTransaction + ", currencyCodeTransaction=" + currencyCodeTransaction + ", taxId=" + taxId + ", totalAmountTransaction=" + totalAmountTransaction + ", totalAmountLocal=" + totalAmountLocal + ", currencyCodeLocal=" + currencyCodeLocal + ", totalAmountSystem=" + totalAmountSystem + ", currencyCodeSystem=" + currencyCodeSystem + ", bookingCommissionItems=" + bookingCommissionItems + ", totalCommissionTransaction=" + totalCommissionTransaction + ", totalCommissionLocal=" + totalCommissionLocal + ", totalCommissionSystem=" + totalCommissionSystem + ", " + super.toString() + '}';
    }


    
}
