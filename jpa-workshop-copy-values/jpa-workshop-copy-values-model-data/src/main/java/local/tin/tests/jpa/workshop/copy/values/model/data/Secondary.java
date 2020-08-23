package local.tin.tests.jpa.workshop.copy.values.model.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import local.tin.tests.jpa.workshop.model.data.abstracts.AbstractNamed;

/**
 *
 * @author benitodarder
 */
@Entity
@Table(name = "SECONDARY")
public class Secondary extends AbstractNamed {
    
    @Id
    private Integer id;
    @Column(name = "VALUE02")
    private String value02;
    @Column(name = "VALUE03")
    private Double value03;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "masterId", referencedColumnName = "id")
    private Master master;
            
    @Override
    public Object getId() {
        return id;
    }

    @Override
    public void setId(Object id) {
        this.id = (Integer) id;
    }

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

    public Master getMaster() {
        return master;
    }

    public void setMaster(Master master) {
        this.master = master;
    }
    
    
    
}
