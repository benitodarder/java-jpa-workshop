package local.tin.tests.jpa.workshop.copy.values.model.data;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import local.tin.tests.jpa.workshop.model.data.interfaces.IIdentifiable;

/**
 *
 * @author benitodarder
 */

@Entity
@Table(name = "BO_BOOKING_ITEM")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BookingItem extends AuditInfo implements IIdentifiable {

    @Id
    @Column(name = "BO_BOOKING_ITEMID")
    @GeneratedValue(generator = "booking_item_generator")
    @SequenceGenerator(name = "booking_item_generator", sequenceName = "SEQ_BO_BOOKING_ITEM", allocationSize = 1)
    private Integer id;

    @Column(name = "BOOKING_DATE")
    private Timestamp bookingDate;

    @Column(name = "CANCEL_DATE")
    private Timestamp cancelDate;
    
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

    public Timestamp getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Timestamp bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Timestamp getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(Timestamp cancelDate) {
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

    
    
}
