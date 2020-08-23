package local.tin.tests.jpa.workshop.copy.values.dao.impl;

import javax.persistence.EntityManagerFactory;
import local.tin.tests.jpa.workshop.copy.values.dao.CopyValuesDAOFactory;
import local.tin.tests.jpa.workshop.copy.values.model.data.Master;
import local.tin.tests.jpa.workshop.copy.values.model.data.Secondary;
import local.tin.tests.jpa.workshop.model.domain.exceptions.DAOException;

/**
 *
 * @author benitodarder
 */
public class MasterDAO extends CopyValuesAbstractDAO<local.tin.tests.jpa.workshop.copy.values.model.domain.Master, Master> {

    public MasterDAO(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory);
    }

    @Override
    protected Class<Master> getDAOClass() {
        return Master.class;
    }

    @Override
    protected local.tin.tests.jpa.workshop.copy.values.model.domain.Master getDomainObjectNewInstance() {
        return new local.tin.tests.jpa.workshop.copy.values.model.domain.Master();
    }

    @Override
    protected Master getDataObjectNewInstance() {
        return new Master();
    }

    @Override
    protected local.tin.tests.jpa.workshop.copy.values.model.domain.Master updateDomainObjectDepth0Fields(local.tin.tests.jpa.workshop.copy.values.model.domain.Master domainObject, Master dataObject) throws DAOException {
        domainObject.setValue01(dataObject.getValue01());
        domainObject.setValue02(dataObject.getValue02());
        domainObject.setValue03(dataObject.getValue03());
        return domainObject;
    }

    @Override
    protected local.tin.tests.jpa.workshop.copy.values.model.domain.Master updateDomainObjectDeeperFields(local.tin.tests.jpa.workshop.copy.values.model.domain.Master domainObject, Master dataObject, int depth) throws DAOException {
        SecondaryDAO secondaryDAO = (SecondaryDAO) CopyValuesDAOFactory.getInstance().getDAO(local.tin.tests.jpa.workshop.copy.values.model.domain.Secondary.class);
        for (Secondary secondary : dataObject.getSecondarys()) {
            domainObject.getSecondarys().add(secondaryDAO.getDomainObject(secondary, depth));
        }
        return domainObject;
    }

    @Override
    protected Master updateDataObjectDepth0Fields(local.tin.tests.jpa.workshop.copy.values.model.domain.Master domainObject, Master dataObject) throws DAOException {
        dataObject.setValue01(domainObject.getValue01());
        dataObject.setValue02(domainObject.getValue02());
        dataObject.setValue03(domainObject.getValue03());
        return dataObject;
    }

    @Override
    protected Master updateDataObjectDeeperFields(local.tin.tests.jpa.workshop.copy.values.model.domain.Master domainObject, Master dataObject, int depth) throws DAOException {
        return dataObject;
    }

}
