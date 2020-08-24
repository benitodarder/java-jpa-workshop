package local.tin.tests.jpa.workshop.copy.values.dao.impl;

import javax.persistence.EntityManagerFactory;
import local.tin.tests.jpa.workshop.copy.values.model.data.Base;
import local.tin.tests.jpa.workshop.model.domain.exceptions.DAOException;

/**
 *
 * @author benitodarder
 * @param <C0>
 * @param <C1>
 */
public abstract class BaseDAO<C0 extends local.tin.tests.jpa.workshop.copy.values.model.domain.Base, C1 extends Base> extends CopyValuesAbstractDAO<C0, C1> {
    
    public BaseDAO(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory);
    }

    @Override
    protected C0 updateDomainObjectDepth0Fields(C0 domainObject, C1 dataObject) throws DAOException {
        domainObject.setName(dataObject.getName());
        domainObject.setCommonValue(dataObject.getCommonValue());
        return domainObject;
    }

    @Override
    protected C1 updateDataObjectDepth0Fields(C0 domainObject, C1 dataObject) throws DAOException {
        dataObject.setName(domainObject.getName());
        dataObject.setCommonValue(domainObject.getCommonValue());
        return dataObject;
    }
    
    
    
}
