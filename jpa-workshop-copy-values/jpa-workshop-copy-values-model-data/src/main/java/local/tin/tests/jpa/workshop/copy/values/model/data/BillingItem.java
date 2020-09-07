package local.tin.tests.jpa.workshop.copy.values.model.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import local.tin.tests.jpa.workshop.model.data.interfaces.IIdentifiable;

/**
 *
 * @author benitodarder
 */
@Entity
@Table(name = "BI_BILLING_ITEM")
public class BillingItem extends AuditInfo  implements IIdentifiable  {

    @Id
    @Column(name = "BI_BILLING_ITEMID")
    @GeneratedValue(generator = "billing_item_generator")
    @SequenceGenerator(name = "billing_item_generator", sequenceName = "SEQ_BI_BILLING_ITEM", allocationSize = 1)
    private Integer id;

    @Column(name = "ITEM_TYPE")
    private String billingItemType;

    @Column(name = "BUSINESS_TYPE")
    private String billingBusinessType;

    @Column(name = "ITEM_SOURCE")
    private String billingItemSource;

    @Column(name = "DEFAULT_FEE")
    private Boolean defaultFee;

    @Column(name = "BO_BOOKINGID")
    private Integer bookingId;

    @Column(name = "BO_BOOKING_ITEMID")
    private Integer bookingItemId;

    @Column(name = "OD_COMPANYID")
    private Integer companyId;

    @Column(name = "OD_VENDORID")
    private Integer vendorId;

    @Column(name = "OD_CUSTOMERID")
    private Integer customerId;

    @Column(name = "OD_FEEID")
    private Integer feeId;

    @Column(name = "INVOICE_ID")
    private Integer invoiceId;

    @Column(name = "DOCUMENT_NUMBER")
    private String documentNumber;

    @Column(name = "CURRENCY_CODE_TRANSACTION")
    private String currencyCodeTransaction;    
    
    @Column(name = "BILLING_ITEM_AMOUNT_TCY")
    private Double amountTransaction;   

    @Column(name = "CURRENCY_CODE_LOCAL")
    private String currencyCodeLocal;    
    
    @Column(name = "BILLING_ITEM_AMOUNT_LCY")
    private Double amountLocal;       
    
    @Column(name = "CURRENCY_CODE_SYSTEM")
    private String currencyCodeSystem;    
    
    @Column(name = "BILLING_ITEM_AMOUNT_SCY")
    private Double amountSystem;    
    
    @Column(name = "INVOICED_ITEM_AMOUNT_TCY")
    private Double invoicedAmountTransaction;  

    @Column(name = "INVOICED_ITEM_AMOUNT_LCY")
    private Double invoicedAmountLocal;      
 
    @Column(name = "INVOICED_ITEM_AMOUNT_SCY")
    private Double invoicedAmountSystem;      
 
    @Column(name = "PAID_ITEM_AMOUNT_TCY")
    private Double paidAmountTransaction;    
    
    @Column(name = "PAID_ITEM_AMOUNT_LCY")
    private Double paidAmountLocal;    
     
    @Column(name = "PAID_ITEM_AMOUNT_SCY")
    private Double paidAmountSystem;   

    @Column(name = "GD_STATUS")
    private String gdStatus;
    
    @Column(name = "GD_STATUSFLOWTYPE")
    private String gdStatusFlowType;    

    @Override
    public Object getId() {
        return id;
    }

    @Override
    public void setId(Object id) {
        this.id = (Integer) id;
    }

    public String getBillingItemType() {
        return billingItemType;
    }

    public void setBillingItemType(String billingItemType) {
        this.billingItemType = billingItemType;
    }

    public String getBillingBusinessType() {
        return billingBusinessType;
    }

    public void setBillingBusinessType(String billingBusinessType) {
        this.billingBusinessType = billingBusinessType;
    }

    public String getBillingItemSource() {
        return billingItemSource;
    }

    public void setBillingItemSource(String billingItemSource) {
        this.billingItemSource = billingItemSource;
    }

    public Boolean getDefaultFee() {
        return defaultFee;
    }

    public void setDefaultFee(Boolean defaultFee) {
        this.defaultFee = defaultFee;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Integer getBookingItemId() {
        return bookingItemId;
    }

    public void setBookingItemId(Integer bookingItemId) {
        this.bookingItemId = bookingItemId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getVendorId() {
        return vendorId;
    }

    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getFeeId() {
        return feeId;
    }

    public void setFeeId(Integer feeId) {
        this.feeId = feeId;
    }

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getCurrencyCodeTransaction() {
        return currencyCodeTransaction;
    }

    public void setCurrencyCodeTransaction(String currencyCodeTransaction) {
        this.currencyCodeTransaction = currencyCodeTransaction;
    }

    public Double getAmountTransaction() {
        return amountTransaction;
    }

    public void setAmountTransaction(Double amountTransaction) {
        this.amountTransaction = amountTransaction;
    }

    public String getCurrencyCodeLocal() {
        return currencyCodeLocal;
    }

    public void setCurrencyCodeLocal(String currencyCodeLocal) {
        this.currencyCodeLocal = currencyCodeLocal;
    }

    public Double getAmountLocal() {
        return amountLocal;
    }

    public void setAmountLocal(Double amountLocal) {
        this.amountLocal = amountLocal;
    }

    public String getCurrencyCodeSystem() {
        return currencyCodeSystem;
    }

    public void setCurrencyCodeSystem(String currencyCodeSystem) {
        this.currencyCodeSystem = currencyCodeSystem;
    }

    public Double getAmountSystem() {
        return amountSystem;
    }

    public void setAmountSystem(Double amountSystem) {
        this.amountSystem = amountSystem;
    }

    public Double getInvoicedAmountTransaction() {
        return invoicedAmountTransaction;
    }

    public void setInvoicedAmountTransaction(Double invoicedAmountTransaction) {
        this.invoicedAmountTransaction = invoicedAmountTransaction;
    }

    public Double getInvoicedAmountLocal() {
        return invoicedAmountLocal;
    }

    public void setInvoicedAmountLocal(Double invoicedAmountLocal) {
        this.invoicedAmountLocal = invoicedAmountLocal;
    }

    public Double getInvoicedAmountSystem() {
        return invoicedAmountSystem;
    }

    public void setInvoicedAmountSystem(Double invoicedAmountSystem) {
        this.invoicedAmountSystem = invoicedAmountSystem;
    }

    public Double getPaidAmountTransaction() {
        return paidAmountTransaction;
    }

    public void setPaidAmountTransaction(Double paidAmountTransaction) {
        this.paidAmountTransaction = paidAmountTransaction;
    }

    public Double getPaidAmountLocal() {
        return paidAmountLocal;
    }

    public void setPaidAmountLocal(Double paidAmountLocal) {
        this.paidAmountLocal = paidAmountLocal;
    }

    public Double getPaidAmountSystem() {
        return paidAmountSystem;
    }

    public void setPaidAmountSystem(Double paidAmountSystem) {
        this.paidAmountSystem = paidAmountSystem;
    }

    public String getGdStatus() {
        return gdStatus;
    }

    public void setGdStatus(String gdStatus) {
        this.gdStatus = gdStatus;
    }

    public String getGdStatusFlowType() {
        return gdStatusFlowType;
    }

    public void setGdStatusFlowType(String gdStatusFlowType) {
        this.gdStatusFlowType = gdStatusFlowType;
    }

    
}
