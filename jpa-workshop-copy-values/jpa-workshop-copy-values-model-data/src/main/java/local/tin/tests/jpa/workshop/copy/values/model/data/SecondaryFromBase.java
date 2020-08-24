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
@Table(name = "SECONDARY_FROM_BASE")
@PrimaryKeyJoinColumn(name = "ID")
public class SecondaryFromBase extends Base { 
    
    @Column(name = "VALUE02")
    private String value02;
    @Column(name = "VALUE03")
    private Double value03;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "masterId", referencedColumnName = "id")
    private MasterFromBase masterFromBase; 
    
    public String getValue02() {
        return value02;
    }

    public void setValue02(String value02) {
        this.value02 = value02;
    }

    public Double getValue03() {
        return value03;
    }

    public void setValue03(Double value03) {
        this.value03 = value03;
    }

    public MasterFromBase getMasterFromBase() {
        return masterFromBase;
    }

    public void setMasterFromBase(MasterFromBase master) {
        this.masterFromBase = master;
    }

    
    
}
