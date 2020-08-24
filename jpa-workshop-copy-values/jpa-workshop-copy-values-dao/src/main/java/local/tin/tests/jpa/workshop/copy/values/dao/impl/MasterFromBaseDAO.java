package local.tin.tests.jpa.workshop.copy.values.dao.impl;

import javax.persistence.EntityManagerFactory;
import local.tin.tests.jpa.workshop.copy.values.dao.CopyValuesDAOFactory;
import local.tin.tests.jpa.workshop.copy.values.model.data.MasterFromBase;
import local.tin.tests.jpa.workshop.model.domain.exceptions.DAOException;

/**
 *
 * @author benitodarder
 */
public class MasterFromBaseDAO extends BaseDAO<local.tin.tests.jpa.workshop.copy.values.model.domain.MasterFromBase, MasterFromBase>{

    public MasterFromBaseDAO(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory);
    }

    @Override
    protected Class<MasterFromBase> getDAOClass() {
        return MasterFromBase.class;
    }

    @Override
    protected local.tin.tests.jpa.workshop.copy.values.model.domain.MasterFromBase getDomainObjectNewInstance() {
        return new local.tin.tests.jpa.workshop.copy.values.model.domain.MasterFromBase();
    }

    @Override
    protected MasterFromBase getDataObjectNewInstance() {
        return new MasterFromBase();
    }

    @Override
    protected local.tin.tests.jpa.workshop.copy.values.model.domain.MasterFromBase updateDomainObjectDeeperFields(local.tin.tests.jpa.workshop.copy.values.model.domain.MasterFromBase domainObject, MasterFromBase dataObject, int depth) throws DAOException {
        SecondaryFromBaseDAO secondaryDAO = (SecondaryFromBaseDAO) CopyValuesDAOFactory.getInstance().getDAO(local.tin.tests.jpa.workshop.copy.values.model.domain.SecondaryFromBase.class);
        for (local.tin.tests.jpa.workshop.copy.values.model.data.SecondaryFromBase secondary : dataObject.getSecondaryFromBases()) {
            domainObject.getSecondaryFromBases().add(secondaryDAO.getDomainObject(secondary, depth));
        }
        return domainObject;        
    }

    @Override
    protected MasterFromBase updateDataObjectDeeperFields(local.tin.tests.jpa.workshop.copy.values.model.domain.MasterFromBase domainObject, MasterFromBase dataObject, int depth) throws DAOException {
        return dataObject;
    }

    @Override
    protected MasterFromBase updateDataObjectDepth0Fields(local.tin.tests.jpa.workshop.copy.values.model.domain.MasterFromBase domainObject, MasterFromBase dataObject) throws DAOException {
        dataObject.setValue01(domainObject.getValue01());
        dataObject.setValue02(domainObject.getValue02());
        dataObject.setValue03(domainObject.getValue03());           
        return super.updateDataObjectDepth0Fields(domainObject, dataObject);
    }

    @Override
    protected local.tin.tests.jpa.workshop.copy.values.model.domain.MasterFromBase updateDomainObjectDepth0Fields(local.tin.tests.jpa.workshop.copy.values.model.domain.MasterFromBase domainObject, MasterFromBase dataObject) throws DAOException {
        domainObject.setValue01(dataObject.getValue01());
        domainObject.setValue02(dataObject.getValue02());
        domainObject.setValue03(dataObject.getValue03());      
        return super.updateDomainObjectDepth0Fields(domainObject, dataObject);
    }
    
    
}
