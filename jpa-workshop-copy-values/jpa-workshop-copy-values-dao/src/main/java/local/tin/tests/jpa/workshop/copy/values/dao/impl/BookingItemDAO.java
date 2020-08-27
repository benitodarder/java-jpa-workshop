package local.tin.tests.jpa.workshop.copy.values.dao.impl;

import javax.persistence.EntityManagerFactory;
import local.tin.tests.jpa.workshop.copy.values.model.data.BookingItem;
import local.tin.tests.jpa.workshop.model.domain.exceptions.DAOException;
import local.tin.tests.jpa.workshop.dao.utils.CommonDAOUtils;
/**
 *
 * @author benitodarder
 */
public abstract class BookingItemDAO <C0 extends local.tin.tests.jpa.workshop.copy.values.model.domain.BookingItem, C1 extends BookingItem> extends CopyValuesAbstractDAO<C0, C1>{
    
    public BookingItemDAO(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory);
    }

    @Override
    protected C0 updateDomainObjectDepth0Fields(C0 domainObject, C1 dataObject) throws DAOException {
        domainObject.setBookingDate(dataObject.getBookingDate());
        domainObject.setCancelDate(dataObject.getCancelDate());
        domainObject.setDbUserIns(dataObject.getDbUserIns());
        domainObject.setDbUserUpdate(dataObject.getDbUserUpdate());
        domainObject.setGdStatus(dataObject.getGdStatus());
        domainObject.setGdStatusFlowType(dataObject.getGdStatusFlowType());
        domainObject.setIdUserInsert(dataObject.getIdUserInsert());
        domainObject.setIdUserUpdate(dataObject.getIdUserUpdate());
        domainObject.setInsertDate(dataObject.getInsertDate());
        domainObject.setModifyDate(dataObject.getModifyDate());
        domainObject.setVersion(dataObject.getVersion());
        return domainObject;
    }

    @Override
    protected C0 updateDomainObjectDeeperFields(C0 domainObject, C1 dataObject, int depth) throws DAOException {
        return domainObject;
    }

    @Override
    protected C1 updateDataObjectDepth0Fields(C0 domainObject, C1 dataObject) throws DAOException {
        dataObject.setBookingDate(CommonDAOUtils.getInstance().getTimeStampFromDate(domainObject.getBookingDate()));
        dataObject.setCancelDate(CommonDAOUtils.getInstance().getTimeStampFromDate(domainObject.getCancelDate()));
        dataObject.setDbUserIns(domainObject.getDbUserIns());
        dataObject.setDbUserUpdate(domainObject.getDbUserUpdate());
        dataObject.setGdStatus(domainObject.getGdStatus());
        dataObject.setGdStatusFlowType(domainObject.getGdStatusFlowType());
        dataObject.setIdUserInsert(domainObject.getIdUserInsert());
        dataObject.setIdUserUpdate(domainObject.getIdUserUpdate());
        dataObject.setInsertDate(CommonDAOUtils.getInstance().getTimeStampFromDate(domainObject.getInsertDate()));
        dataObject.setModifyDate(CommonDAOUtils.getInstance().getTimeStampFromDate(domainObject.getModifyDate()));
        dataObject.setVersion(domainObject.getVersion());
        return dataObject;
    }

    @Override
    protected C1 updateDataObjectDeeperFields(C0 domainObject, C1 dataObject, int depth) throws DAOException {
        return dataObject;
    }
    
    
}
