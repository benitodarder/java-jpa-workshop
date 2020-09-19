package local.tin.tests.jpa.workshop.copy.values.dao.impl;

import java.util.Collection;
import java.util.HashSet;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import local.tin.tests.jpa.workshop.copy.values.dao.interfaces.IBillingItemDAO;
import local.tin.tests.jpa.workshop.copy.values.model.data.BillingItem;
import static local.tin.tests.jpa.workshop.dao.impl.AbstractDAO.DEFAULT_DEPTH_ENTITY;
import local.tin.tests.jpa.workshop.dao.utils.CommonDAOUtils;
import local.tin.tests.jpa.workshop.model.domain.exceptions.DAOException;

/**
 *
 * @author benitodarder
 */
public class BillingItemDAO extends CopyValuesAbstractDAO<local.tin.tests.jpa.workshop.copy.values.model.domain.BillingItem, local.tin.tests.jpa.workshop.copy.values.model.data.BillingItem> implements IBillingItemDAO {
    
    public static final String QUERY_BY_BOOKING_ITEM_ID = "SELECT b FROM BillingItem b WHERE b.bookingItemId = :bookingItemId";

    public BillingItemDAO(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory);
    }

    @Override
    protected Class<BillingItem> getDAOClass() {
        return local.tin.tests.jpa.workshop.copy.values.model.data.BillingItem.class;
    }

    @Override
    protected local.tin.tests.jpa.workshop.copy.values.model.domain.BillingItem getDomainObjectNewInstance() {
        return new local.tin.tests.jpa.workshop.copy.values.model.domain.BillingItem();
    }

    @Override
    protected BillingItem getDataObjectNewInstance() {
        return new local.tin.tests.jpa.workshop.copy.values.model.data.BillingItem();
    }

    @Override
    protected local.tin.tests.jpa.workshop.copy.values.model.domain.BillingItem updateDomainObjectDepth0Fields(local.tin.tests.jpa.workshop.copy.values.model.domain.BillingItem domainObject, BillingItem dataObject) throws DAOException {
        domainObject.setAmountLocal(dataObject.getAmountLocal());
        domainObject.setAmountSystem(dataObject.getAmountSystem());
        domainObject.setAmountTransaction(dataObject.getAmountTransaction());
        domainObject.setBillingBusinessType(dataObject.getBillingBusinessType());
        domainObject.setBillingItemSource(dataObject.getBillingItemSource());
        domainObject.setBillingItemType(dataObject.getBillingItemType());
        domainObject.setBookingId(dataObject.getBookingId());
        domainObject.setBookingItemId(dataObject.getBookingItemId());
        domainObject.setCompanyId(dataObject.getCompanyId());
        domainObject.setCurrencyCodeLocal(dataObject.getCurrencyCodeLocal());
        domainObject.setCurrencyCodeSystem(dataObject.getCurrencyCodeSystem());
        domainObject.setCurrencyCodeTransaction(dataObject.getCurrencyCodeTransaction());
        domainObject.setCustomerId(dataObject.getCustomerId());
        domainObject.setDbUserIns(dataObject.getDbUserIns());
        domainObject.setDbUserUpdate(dataObject.getDbUserUpdate());
        domainObject.setDefaultFee(dataObject.getDefaultFee());
        domainObject.setDocumentNumber(dataObject.getDocumentNumber());
        domainObject.setFeeId(dataObject.getFeeId());
        domainObject.setGdStatus(dataObject.getGdStatus());
        domainObject.setGdStatusFlowType(dataObject.getGdStatusFlowType());
        domainObject.setIdUserInsert(dataObject.getIdUserInsert());
        domainObject.setIdUserUpdate(dataObject.getIdUserUpdate());
        domainObject.setInsertDate(dataObject.getInsertDate());
        domainObject.setInvoiceId(dataObject.getInvoiceId());
        domainObject.setInvoicedAmountLocal(dataObject.getInvoicedAmountLocal());
        domainObject.setInvoicedAmountSystem(dataObject.getInvoicedAmountSystem());
        domainObject.setInvoicedAmountTransaction(dataObject.getInvoicedAmountTransaction());
        domainObject.setModifyDate(dataObject.getModifyDate());
        domainObject.setPaidAmountLocal(dataObject.getPaidAmountLocal());
        domainObject.setPaidAmountSystem(dataObject.getPaidAmountSystem());
        domainObject.setPaidAmountTransaction(dataObject.getPaidAmountTransaction());
        domainObject.setVendorId(dataObject.getVendorId());
        domainObject.setVersion(dataObject.getVersion());
        return domainObject;
    }

    @Override
    protected local.tin.tests.jpa.workshop.copy.values.model.domain.BillingItem updateDomainObjectDeeperFields(local.tin.tests.jpa.workshop.copy.values.model.domain.BillingItem domainObject, BillingItem dataObject, int depth) throws DAOException {
        return domainObject;
    }

    @Override
    protected BillingItem updateDataObjectDepth0Fields(local.tin.tests.jpa.workshop.copy.values.model.domain.BillingItem domainObject, BillingItem dataObject) throws DAOException {
        dataObject.setAmountLocal(domainObject.getAmountLocal());
        dataObject.setAmountSystem(domainObject.getAmountSystem());
        dataObject.setAmountTransaction(domainObject.getAmountTransaction());
        dataObject.setBillingBusinessType(domainObject.getBillingBusinessType());
        dataObject.setBillingItemSource(domainObject.getBillingItemSource());
        dataObject.setBillingItemType(domainObject.getBillingItemType());
        dataObject.setBookingId(domainObject.getBookingId());
        dataObject.setBookingItemId(domainObject.getBookingItemId());
        dataObject.setCompanyId(domainObject.getCompanyId());
        dataObject.setCurrencyCodeLocal(domainObject.getCurrencyCodeLocal());
        dataObject.setCurrencyCodeSystem(domainObject.getCurrencyCodeSystem());
        dataObject.setCurrencyCodeTransaction(domainObject.getCurrencyCodeTransaction());
        dataObject.setCustomerId(domainObject.getCustomerId());
        dataObject.setDbUserIns(domainObject.getDbUserIns());
        dataObject.setDbUserUpdate(domainObject.getDbUserUpdate());
        dataObject.setDefaultFee(domainObject.getDefaultFee());
        dataObject.setDocumentNumber(domainObject.getDocumentNumber());
        dataObject.setFeeId(domainObject.getFeeId());
        dataObject.setGdStatus(domainObject.getGdStatus());
        dataObject.setGdStatusFlowType(domainObject.getGdStatusFlowType());
        dataObject.setIdUserInsert(domainObject.getIdUserInsert());
        dataObject.setIdUserUpdate(domainObject.getIdUserUpdate());
        dataObject.setInsertDate(CommonDAOUtils.getInstance().getTimeStampFromDate(domainObject.getInsertDate()));
        dataObject.setInvoiceId(domainObject.getInvoiceId());
        dataObject.setInvoicedAmountLocal(domainObject.getInvoicedAmountLocal());
        dataObject.setInvoicedAmountSystem(domainObject.getInvoicedAmountSystem());
        dataObject.setInvoicedAmountTransaction(domainObject.getInvoicedAmountTransaction());
        dataObject.setModifyDate(CommonDAOUtils.getInstance().getTimeStampFromDate(domainObject.getModifyDate()));
        dataObject.setPaidAmountLocal(domainObject.getPaidAmountLocal());
        dataObject.setPaidAmountSystem(domainObject.getPaidAmountSystem());
        dataObject.setPaidAmountTransaction(domainObject.getPaidAmountTransaction());
        dataObject.setVendorId(domainObject.getVendorId());
        dataObject.setVersion(domainObject.getVersion());
        return dataObject;
    }

    @Override
    protected BillingItem updateDataObjectDeeperFields(local.tin.tests.jpa.workshop.copy.values.model.domain.BillingItem domainObject, BillingItem dataObject, int depth) throws DAOException {
        return dataObject;
    }
    
    
    
    @Override
    public Collection<local.tin.tests.jpa.workshop.copy.values.model.domain.BillingItem> retrieveByBookingItem(Integer bookingItemId) throws DAOException {
        EntityManager entityManager = getEntityManager();
        Collection<local.tin.tests.jpa.workshop.copy.values.model.domain.BillingItem> results = new HashSet<>();
        try {
            Collection<BillingItem> billingItemsData = retrieveByBookingItem(entityManager, bookingItemId);
            for (BillingItem current : billingItemsData) {
                results.add(getDomainObject(current, DEFAULT_DEPTH_ENTITY));
            }
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return results;
    }

    protected Collection<BillingItem> retrieveByBookingItem(EntityManager entityManager, Integer bookingItemId) throws DAOException {
        Query query = entityManager.createQuery(QUERY_BY_BOOKING_ITEM_ID);
        query.setParameter("bookingItemId", bookingItemId);
        return query.getResultList();
    }    
}
