package local.tin.tests.jpa.workshop.generic.dao.tests.model;

import local.tin.tests.jpa.workshop.model.data.abstracts.AbstractNamed;

/**
 *
 * @author developer01
 */
public class DataClassEmbeddedId extends AbstractNamed {
    
    private EmbeddedId id;
    private DataClassSimpleId relatedObject;
    
    @Override
    public Object getId() {
        return id;
    }

    @Override
    public void setId(Object id) {
        this.id = (EmbeddedId) id;
    }

    public DataClassSimpleId getRelatedObject() {
        return relatedObject;
    }

    public void setRelatedObject(DataClassSimpleId relatedObject) {
        this.relatedObject = relatedObject;
    }


    
    
}
