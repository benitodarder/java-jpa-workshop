package local.tin.tests.jpa.workshop.generic.dao.tests.model;

import local.tin.tests.jpa.workshop.model.domain.interfaces.ICompositeId;



/**
 *
 * @author developer01
 */
public class CompositeId implements ICompositeId {

    private String string;
    private Integer integer;

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }    
    
}
