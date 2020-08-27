package local.tin.tests.jpa.workshop.copy.values.model.domain;

import java.util.Date;
import local.tin.tests.jpa.workshop.model.domain.interfaces.IIdentifiable;

/**
 *
 * @author benitodarder
 */
public abstract class BookingItem extends AuditInfo implements IIdentifiable {
    
    private Integer id;
    private Date bookingDate;
    private Date cancelDate;
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

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Date getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(Date cancelDate) {
        this.cancelDate = cancelDate;
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
        return "BookingItem{" + "id=" + id + ", bookingDate=" + bookingDate + ", cancelDate=" + cancelDate + ", gdStatus=" + gdStatus + ", gdStatusFlowType=" + gdStatusFlowType +  super.toString() + '}';
    }
    
    
}
