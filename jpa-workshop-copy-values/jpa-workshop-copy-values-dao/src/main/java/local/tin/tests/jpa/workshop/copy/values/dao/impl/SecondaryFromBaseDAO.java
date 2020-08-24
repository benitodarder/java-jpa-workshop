package local.tin.tests.jpa.workshop.copy.values.dao.impl;

import javax.persistence.EntityManagerFactory;
import local.tin.tests.jpa.workshop.copy.values.dao.CopyValuesDAOFactory;
import local.tin.tests.jpa.workshop.copy.values.model.data.SecondaryFromBase;
import local.tin.tests.jpa.workshop.model.domain.exceptions.DAOException;

/**
 *
 * @author benitodarder
 */
public class SecondaryFromBaseDAO extends BaseDAO<local.tin.tests.jpa.workshop.copy.values.model.domain.SecondaryFromBase, SecondaryFromBase> {

    public SecondaryFromBaseDAO(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory);
    }

    @Override
    protected Class<SecondaryFromBase> getDAOClass() {
        return SecondaryFromBase.class;
    }

    @Override
    protected local.tin.tests.jpa.workshop.copy.values.model.domain.SecondaryFromBase getDomainObjectNewInstance() {
        return new local.tin.tests.jpa.workshop.copy.values.model.domain.SecondaryFromBase();
    }

    @Override
    protected SecondaryFromBase getDataObjectNewInstance() {
        return new SecondaryFromBase();
    }

    @Override
    protected local.tin.tests.jpa.workshop.copy.values.model.domain.SecondaryFromBase updateDomainObjectDeeperFields(local.tin.tests.jpa.workshop.copy.values.model.domain.SecondaryFromBase domainObject, SecondaryFromBase dataObject, int depth) throws DAOException {
        MasterFromBaseDAO masterDAO = (MasterFromBaseDAO) CopyValuesDAOFactory.getInstance().getDAO(local.tin.tests.jpa.workshop.copy.values.model.domain.MasterFromBase.class);
        domainObject.setMasterFromBase(masterDAO.getDomainObject(dataObject.getMasterFromBase(), depth));
        return domainObject;
    }

    @Override
    protected SecondaryFromBase updateDataObjectDeeperFields(local.tin.tests.jpa.workshop.copy.values.model.domain.SecondaryFromBase domainObject, SecondaryFromBase dataObject, int depth) throws DAOException {
        MasterFromBaseDAO masterDAO = (MasterFromBaseDAO) CopyValuesDAOFactory.getInstance().getDAO(local.tin.tests.jpa.workshop.copy.values.model.domain.MasterFromBase.class);
        dataObject.setMasterFromBase(masterDAO.getDataObject(domainObject.getMasterFromBase(), depth));
        return dataObject;
    }

    @Override
    protected SecondaryFromBase updateDataObjectDepth0Fields(local.tin.tests.jpa.workshop.copy.values.model.domain.SecondaryFromBase domainObject, SecondaryFromBase dataObject) throws DAOException {
        dataObject.setValue02(domainObject.getValue02());
        dataObject.setValue03(domainObject.getValue03());
        return super.updateDataObjectDepth0Fields(domainObject, dataObject);
    }

    @Override
    protected local.tin.tests.jpa.workshop.copy.values.model.domain.SecondaryFromBase updateDomainObjectDepth0Fields(local.tin.tests.jpa.workshop.copy.values.model.domain.SecondaryFromBase domainObject, SecondaryFromBase dataObject) throws DAOException {
        domainObject.setValue02(dataObject.getValue02());
        domainObject.setValue03(dataObject.getValue03());         
        return super.updateDomainObjectDepth0Fields(domainObject, dataObject);
    }

}
