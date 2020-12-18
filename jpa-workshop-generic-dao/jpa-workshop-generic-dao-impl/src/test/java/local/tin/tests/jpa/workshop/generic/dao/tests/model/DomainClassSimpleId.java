package local.tin.tests.jpa.workshop.generic.dao.tests.model;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import local.tin.tests.jpa.workshop.model.domain.abstracts.AbstractNamed;

/**
 *
 * @author developer01
 */
public class DomainClassSimpleId extends AbstractNamed {

    private Integer id;
    private Collection<DomainClassCompositeId> relatedObjects;
    private Date date;
    
    @Override
    public Object getId() {
        return id;
    }

    @Override
    public void setId(Object id) {
        this.id = (Integer) id;
    }

    public Collection<DomainClassCompositeId> getRelatedObjects() {
        if (relatedObjects == null) {
            relatedObjects = new HashSet<>();
        }
        return relatedObjects;
    }

    public void setRelatedObjects(Collection<DomainClassCompositeId> relatedObjects) {
        this.relatedObjects = relatedObjects;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }



    
}
