package local.tin.tests.jpa.workshop.generic.dao.tests.model;

import local.tin.tests.jpa.workshop.model.domain.abstracts.AbstractNamed;

/**
 *
 * @author developer01
 */
public class DomainClassCompositeId extends AbstractNamed {

    private CompositeId id;
    private DomainClassSimpleId relatedObject;
    
    @Override
    public Object getId() {
        return id;
    }

    @Override
    public void setId(Object id) {
        this.id = (CompositeId) id;
    }

    public DomainClassSimpleId getRelatedObject() {
        return relatedObject;
    }

    public void setRelatedObject(DomainClassSimpleId relatedObject) {
        this.relatedObject = relatedObject;
    }


    
}
