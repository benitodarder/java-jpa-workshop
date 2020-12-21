package local.tin.tests.jpa.workshop.generic.dao.impl;

import javax.persistence.EntityManagerFactory;

/**
 *
 * @author benitodarder
 */
public class UnitDAO extends GenericAbstractDAO<local.tin.tests.jpa.workshop.model.domain.product.Unit, local.tin.tests.jpa.workshop.model.data.product.Unit>{

    public UnitDAO(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory);
    }

    @Override
    protected Class<local.tin.tests.jpa.workshop.model.domain.product.Unit> getDAODomainClass() {
        return local.tin.tests.jpa.workshop.model.domain.product.Unit.class;
    }

    @Override
    protected Class<local.tin.tests.jpa.workshop.model.data.product.Unit> getDAOClass() {
        return local.tin.tests.jpa.workshop.model.data.product.Unit.class;
    }
    
}
