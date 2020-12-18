package local.tin.tests.jpa.workshop.generic.dao.tests.model;

import java.sql.Date;
import java.util.Collection;
import java.util.HashSet;
import local.tin.tests.jpa.workshop.model.data.abstracts.AbstractNamed;

/**
 *
 * @author developer01
 */
public class DataClassSimpleId extends AbstractNamed {

    private Integer id;
    private Collection<DataClassEmbeddedId> relatedObjects;
    private Date date;
    
    @Override
    public Object getId() {
        return id;
    }

    @Override
    public void setId(Object id) {
        this.id = (Integer) id;
    }

    public Collection<DataClassEmbeddedId> getRelatedObjects() {
        if (relatedObjects == null) {
            relatedObjects = new HashSet<>();
        }
        return relatedObjects;
    }

    public void setRelatedObjects(Collection<DataClassEmbeddedId> relatedObjects) {
        this.relatedObjects = relatedObjects;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    
}
