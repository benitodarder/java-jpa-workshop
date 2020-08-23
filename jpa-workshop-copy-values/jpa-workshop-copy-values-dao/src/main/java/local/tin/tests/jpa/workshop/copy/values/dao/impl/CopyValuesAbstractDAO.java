package local.tin.tests.jpa.workshop.copy.values.dao.impl;

import javax.persistence.EntityManagerFactory;
import local.tin.tests.jpa.workshop.dao.impl.AbstractDAO;
import local.tin.tests.jpa.workshop.model.domain.exceptions.DAOException;

/**
 *
 * @author benitodarder
 * @param <C0>
 * @param <C1>
 */
public abstract class CopyValuesAbstractDAO<C0 extends local.tin.tests.jpa.workshop.model.domain.interfaces.IIdentifiable, C1 extends local.tin.tests.jpa.workshop.model.data.interfaces.IIdentifiable> extends AbstractDAO<C0, C1> {
    
    public CopyValuesAbstractDAO(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory);
    }

    @Override
    protected C1 getDataObject(C0 domainObject, int depth) throws DAOException {
        return super.getDataObject(domainObject, depth);
    }

    @Override
    protected C0 getDomainObject(C1 dataObject, int depth) throws DAOException {
        return super.getDomainObject(dataObject, depth);
    }
    
    
}
