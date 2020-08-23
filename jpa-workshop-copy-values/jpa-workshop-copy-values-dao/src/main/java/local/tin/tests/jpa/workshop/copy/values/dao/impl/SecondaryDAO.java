package local.tin.tests.jpa.workshop.copy.values.dao.impl;

import javax.persistence.EntityManagerFactory;
import local.tin.tests.jpa.workshop.copy.values.dao.CopyValuesDAOFactory;
import local.tin.tests.jpa.workshop.copy.values.model.data.Secondary;
import local.tin.tests.jpa.workshop.model.domain.exceptions.DAOException;

/**
 *
 * @author benitodarder
 */
public class SecondaryDAO extends CopyValuesAbstractDAO<local.tin.tests.jpa.workshop.copy.values.model.domain.Secondary, Secondary> {

    public SecondaryDAO(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory);
    }

    @Override
    protected Class<Secondary> getDAOClass() {
        return Secondary.class;
    }

    @Override
    protected local.tin.tests.jpa.workshop.copy.values.model.domain.Secondary getDomainObjectNewInstance() {
        return new local.tin.tests.jpa.workshop.copy.values.model.domain.Secondary();
    }

    @Override
    protected Secondary getDataObjectNewInstance() {
        return new Secondary();
    }

    @Override
    protected local.tin.tests.jpa.workshop.copy.values.model.domain.Secondary updateDomainObjectDepth0Fields(local.tin.tests.jpa.workshop.copy.values.model.domain.Secondary domainObject, Secondary dataObject) throws DAOException {
        domainObject.setValue02(dataObject.getValue02());
        domainObject.setValue03(dataObject.getValue03());
        return domainObject;
    }

    @Override
    protected local.tin.tests.jpa.workshop.copy.values.model.domain.Secondary updateDomainObjectDeeperFields(local.tin.tests.jpa.workshop.copy.values.model.domain.Secondary domainObject, Secondary dataObject, int depth) throws DAOException {
        MasterDAO masterDAO = (MasterDAO) CopyValuesDAOFactory.getInstance().getDAO(local.tin.tests.jpa.workshop.copy.values.model.domain.Master.class);
        domainObject.setMaster(masterDAO.getDomainObject(dataObject.getMaster(), depth));
        return domainObject;
    }

    @Override
    protected Secondary updateDataObjectDepth0Fields(local.tin.tests.jpa.workshop.copy.values.model.domain.Secondary domainObject, Secondary dataObject) throws DAOException {
        dataObject.setValue02(domainObject.getValue02());
        dataObject.setValue03(domainObject.getValue03());
        return dataObject;
    }

    @Override
    protected Secondary updateDataObjectDeeperFields(local.tin.tests.jpa.workshop.copy.values.model.domain.Secondary domainObject, Secondary dataObject, int depth) throws DAOException {
        MasterDAO masterDAO = (MasterDAO) CopyValuesDAOFactory.getInstance().getDAO(local.tin.tests.jpa.workshop.copy.values.model.domain.Master.class);
        dataObject.setMaster(masterDAO.getDataObject(domainObject.getMaster(), depth));        
        return dataObject;
    }
    
}
