package local.tin.tests.jpa.workshop.copy.values.model.data;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author benitodarder
 */
@Entity
@Table(name = "BO_BOOKING_PRODUCT_ITEM")
@PrimaryKeyJoinColumn(name = "BO_BOOKING_PRODUCT_ITEMID")
public class BookingProductItem extends BookingItem {
    
    @Column(name = "BO_BOOKINGID")
    private Integer booking;

    @Column(name = "OD_PRODUCTID")
    private Integer productId;

    @Column(name = "SELLER_COMPANYID")
    private Integer sellerCompanyId;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "BOOKING_PRODUCT_ITEM_REFERENCE")
    private String bookingProductReference;

    @Column(name = "INVOICE_DATE")
    private Timestamp invoiceDate;

    @Column(name = "SEND_USER_NOTIFICATION")
    private Boolean sendNewUserBookingNotification;

    @Column(name = "OD_CXL_POLICY_RULEID")
    private Integer cancellationPolicyRuleId;

    @Column(name = "CANCEL_AMOUNT_TCY")
    private Double cancelAmountTransaction;
    
    @Column(name = "CURRENCY_CODE_TRANSACTION")
    private String currencyCodeTransaction;

    @Column(name = "OD_TAXID")
    private Integer taxId;

    @Column(name = "TOTAL_AMOUNT_TCY")
    private Double totalAmountTransaction;    

    @Column(name = "TOTAL_AMOUNT_LCY")
    private Double totalAmountLocal;
    
    @Column(name = "CURRENCY_CODE_LOCAL")
    private String currencyCodeLocal;    


    @Column(name = "TOTAL_AMOUNT_SCY")
    private Double totalAmountSystem;
    
    @Column(name = "CURRENCY_CODE_SYSTEM")
    private String currencyCodeSystem;       
    
    @OneToMany(mappedBy = "bookingProductItem", cascade = CascadeType.REMOVE)
    private Collection<BookingCommissionItem> bookingCommissionItems;
    
    @Column(name = "TOTAL_COMMISION_AMOUNT_TCY")
    private Double totalCommissionTransaction;    
    

    @Column(name = "TOTAL_COMMISION_AMOUNT_LCY")
    private Double totalCommissionLocal;
    

    @Column(name = "TOTAL_COMMISION_AMOUNT_SCY")
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

    public Timestamp getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Timestamp invoiceDate) {
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

    
    
}
