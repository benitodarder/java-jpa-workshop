package local.tin.tests.jpa.workshop.dao.impl;

import javax.persistence.EntityManagerFactory;
import local.tin.tests.jpa.workshop.model.domain.exceptions.DAOException;

/**
 *
 * @author benitodarder
 * @param <C0>
 * @param <C1>
 */
public abstract class AbstractEnableableDAO<C0 extends local.tin.tests.jpa.workshop.model.domain.interfaces.IEnableable, C1 extends local.tin.tests.jpa.workshop.model.data.interfaces.IEnableable> extends AbstractDAO<C0, C1> {

    public AbstractEnableableDAO(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory);
    }

    /**
     * Assigns common fields.
     *
     * @param domainObject C0
     * @param dataObject C1
     * @return C0
     * @throws local.tin.tests.jpa.workshop.model.domain.exceptions.DAOException
     */
    @Override
    protected C0 updateDomainCommonFields(C0 domainObject, C1 dataObject) throws DAOException {
        domainObject.setEnabled(dataObject.isEnabled());
        return super.updateDomainCommonFields(domainObject, dataObject);
    }

    /**
     * Assigns common fields.
     *
     * @param domainObject C0
     * @param dataObject C1
     * @return C0
     * @throws local.tin.tests.jpa.workshop.model.domain.exceptions.DAOException
     */
    @Override
    protected C1 updateDataCommonFields(C0 domainObject, C1 dataObject) throws DAOException {
        dataObject.setEnabled(domainObject.isEnabled());
        return super.updateDataCommonFields(domainObject, dataObject);
    }    
}
