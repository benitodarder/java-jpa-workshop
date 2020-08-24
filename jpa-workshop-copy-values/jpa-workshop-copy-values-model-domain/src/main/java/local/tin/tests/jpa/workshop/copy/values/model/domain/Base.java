package local.tin.tests.jpa.workshop.copy.values.model.domain;

import local.tin.tests.jpa.workshop.model.domain.abstracts.AbstractNamed;



/**
 *
 * @author benitodarder
 */
public abstract class Base extends AbstractNamed {
    
    private Integer id;
    private String commonValue;    

    @Override
    public Object getId() {
        return id;
    }

    @Override
    public void setId(Object id) {
        this.id = (Integer) id;
    }



    public String getCommonValue() {
        return commonValue;
    }

    public void setCommonValue(String commonValue) {
        this.commonValue = commonValue;
    }

    @Override
    public String toString() {
        return "Base{" + "id=" + id + ", commonValue=" + commonValue + ". " + super.toString() + '}';
    }
    
    
    
}
