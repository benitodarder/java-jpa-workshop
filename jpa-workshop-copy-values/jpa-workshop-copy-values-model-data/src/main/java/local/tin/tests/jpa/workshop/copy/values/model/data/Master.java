package local.tin.tests.jpa.workshop.copy.values.model.data;

import java.util.Collection;
import java.util.HashSet;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import local.tin.tests.jpa.workshop.model.data.abstracts.AbstractNamed;

/**
 *
 * @author benitodarder
 */
@Entity
@Table(name = "MASTER")
public class Master extends AbstractNamed {
    
    @Id
    private Integer id;
    @Column(name = "VALUE01")
    private Double value01;
    @Column(name = "VALUE02")
    private String value02;
    @Column(name = "VALUE03")
    private Double value03;
    @OneToMany(mappedBy = "master", fetch = FetchType.LAZY)
    private Collection<Secondary> secondarys;    

    @Override
    public Object getId() {
        return id;
    }

    @Override
    public void setId(Object id) {
        this.id = (Integer) id;
    }

    public Double getValue01() {
        return value01;
    }

    public void setValue01(Double value01) {
        this.value01 = value01;
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

    public Collection<Secondary> getSecondarys() {
        if (secondarys == null) {
            secondarys = new HashSet<>();
        }
        return secondarys;
    }

    public void setSecondarys(Collection<Secondary> secondarys) {
        this.secondarys = secondarys;
    }
    
    
    
}
