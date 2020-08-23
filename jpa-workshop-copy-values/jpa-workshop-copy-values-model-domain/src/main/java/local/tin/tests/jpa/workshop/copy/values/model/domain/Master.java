package local.tin.tests.jpa.workshop.copy.values.model.domain;

import java.util.Collection;
import java.util.HashSet;
import local.tin.tests.jpa.workshop.model.domain.abstracts.AbstractNamed;


/**
 *
 * @author benitodarder
 */

public class Master extends AbstractNamed {
    
    private Integer id;
    private Double value01;
    private String value02;
    private Double value03;
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

    @Override
    public String toString() {
        return "Master{" + "id=" + id + ", value01=" + value01 + ", value02=" + value02 + ", value03=" + value03 + ", secondarys=" + secondarys + '}';
    }
    
    
    
}
