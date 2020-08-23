package local.tin.tests.jpa.workshop.copy.values.model.domain;

import local.tin.tests.jpa.workshop.model.domain.abstracts.AbstractNamed;


/**
 *
 * @author benitodarder
 */

public class Secondary extends AbstractNamed {
    
    private Integer id;
    private String value02;
    private Double value03;
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

    @Override
    public String toString() {
        return "Secondary{" + "id=" + id + ", value02=" + value02 + ", value03=" + value03 + ", master=" + master + '}';
    }
    
    
    
}
