package local.tin.tests.jpa.workshop.generic.dao.impl;

import javax.persistence.EntityManagerFactory;

/**
 *
 * @author benitodarder
 */
public class ComponentDAO extends GenericAbstractDAO<local.tin.tests.jpa.workshop.model.domain.product.Component, local.tin.tests.jpa.workshop.model.data.product.Component>{

    public ComponentDAO(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory);
    }

    @Override
    protected Class<local.tin.tests.jpa.workshop.model.domain.product.Component> getDAODomainClass() {
        return local.tin.tests.jpa.workshop.model.domain.product.Component.class;
    }

    @Override
    protected Class<local.tin.tests.jpa.workshop.model.data.product.Component> getDAOClass() {
        return local.tin.tests.jpa.workshop.model.data.product.Component.class;
    }
    
}
