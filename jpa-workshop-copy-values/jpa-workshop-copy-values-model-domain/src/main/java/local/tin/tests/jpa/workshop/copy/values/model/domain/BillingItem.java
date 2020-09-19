package local.tin.tests.jpa.workshop.copy.values.model.domain;

import local.tin.tests.jpa.workshop.model.domain.interfaces.IIdentifiable;

/**
 *
 * @author benitodarder
 */
public class BillingItem extends AuditInfo  implements IIdentifiable  {

    private Integer id;
    private String billingItemType;
    private String billingBusinessType;
    private String billingItemSource;
    private Boolean defaultFee;
    private Integer bookingId;
    private Integer bookingItemId;
    private Integer companyId;
    private Integer vendorId;
    private Integer customerId;
    private Integer feeId;
    private Integer invoiceId;
    private String documentNumber;
    private String currencyCodeTransaction;    
    private Double amountTransaction;   
    private String currencyCodeLocal;    
    private Double amountLocal;       
    private String currencyCodeSystem;    
    private Double amountSystem;    
    private Double invoicedAmountTransaction;  
    private Double invoicedAmountLocal;      
    private Double invoicedAmountSystem;      
    private Double paidAmountTransaction;    
    private Double paidAmountLocal;    
    private Double paidAmountSystem;   
    private String gdStatus;
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

    @Override
    public String toString() {
        return "BillingItem{" + "id=" + id + ", billingItemType=" + billingItemType + ", billingBusinessType=" + billingBusinessType + ", billingItemSource=" + billingItemSource + ", defaultFee=" + defaultFee + ", bookingId=" + bookingId + ", bookingItemId=" + bookingItemId + ", companyId=" + companyId + ", vendorId=" + vendorId + ", customerId=" + customerId + ", feeId=" + feeId + ", invoiceId=" + invoiceId + ", documentNumber=" + documentNumber + ", currencyCodeTransaction=" + currencyCodeTransaction + ", amountTransaction=" + amountTransaction + ", currencyCodeLocal=" + currencyCodeLocal + ", amountLocal=" + amountLocal + ", currencyCodeSystem=" + currencyCodeSystem + ", amountSystem=" + amountSystem + ", invoicedAmountTransaction=" + invoicedAmountTransaction + ", invoicedAmountLocal=" + invoicedAmountLocal + ", invoicedAmountSystem=" + invoicedAmountSystem + ", paidAmountTransaction=" + paidAmountTransaction + ", paidAmountLocal=" + paidAmountLocal + ", paidAmountSystem=" + paidAmountSystem + ", gdStatus=" + gdStatus + ", gdStatusFlowType=" + gdStatusFlowType + ", " + super.toString() + '}';
    }

    
    
}
