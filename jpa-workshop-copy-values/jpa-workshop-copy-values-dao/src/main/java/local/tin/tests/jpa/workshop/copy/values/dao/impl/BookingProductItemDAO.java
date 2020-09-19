package local.tin.tests.jpa.workshop.copy.values.dao.impl;

import java.util.Collection;
import java.util.HashSet;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import local.tin.tests.jpa.workshop.copy.values.dao.CopyValuesDAOFactory;
import local.tin.tests.jpa.workshop.copy.values.dao.interfaces.IBookingProductDAO;
import local.tin.tests.jpa.workshop.copy.values.model.data.BookingCommissionItem;
import local.tin.tests.jpa.workshop.copy.values.model.data.BookingProductItem;
import local.tin.tests.jpa.workshop.dao.utils.CommonDAOUtils;
import local.tin.tests.jpa.workshop.model.domain.exceptions.DAOException;

/**
 *
 * @author benitodarder
 */
public class BookingProductItemDAO extends BookingItemDAO<local.tin.tests.jpa.workshop.copy.values.model.domain.BookingProductItem, BookingProductItem> implements IBookingProductDAO {

    public static final String QUERY_WITH_COMMISSION = "SELECT b FROM BookingProductItem b WHERE b.totalCommissionLocal IS NOT NULL OR b.totalCommissionSystem  IS NOT NULL OR b.totalCommissionTransaction  IS NOT null";

    public BookingProductItemDAO(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory);
    }

    @Override
    protected Class<BookingProductItem> getDAOClass() {
        return BookingProductItem.class;

    }

    @Override
    protected local.tin.tests.jpa.workshop.copy.values.model.domain.BookingProductItem getDomainObjectNewInstance() {
        return new local.tin.tests.jpa.workshop.copy.values.model.domain.BookingProductItem();
    }

    @Override
    protected BookingProductItem getDataObjectNewInstance() {
        return new BookingProductItem();
    }

    @Override
    protected BookingProductItem updateDataObjectDepth0Fields(local.tin.tests.jpa.workshop.copy.values.model.domain.BookingProductItem domainObject, BookingProductItem dataObject) throws DAOException {
        dataObject.setBooking(domainObject.getBooking());
        dataObject.setBookingProductReference(domainObject.getBookingProductReference());
        dataObject.setCancelAmountTransaction(domainObject.getCancelAmountTransaction());
        dataObject.setCancellationPolicyRuleId(domainObject.getCancellationPolicyRuleId());
        dataObject.setCurrencyCodeLocal(domainObject.getCurrencyCodeLocal());
        dataObject.setCurrencyCodeSystem(domainObject.getCurrencyCodeSystem());
        dataObject.setCurrencyCodeTransaction(domainObject.getCurrencyCodeTransaction());
        dataObject.setInvoiceDate(CommonDAOUtils.getInstance().getTimeStampFromDate(domainObject.getInvoiceDate()));
        dataObject.setProductId(domainObject.getProductId());
        dataObject.setProductName(dataObject.getProductName());
        dataObject.setSellerCompanyId(domainObject.getSellerCompanyId());
        dataObject.setSendNewUserBookingNotification(domainObject.getSendNewUserBookingNotification());
        dataObject.setTaxId(domainObject.getTaxId());
        dataObject.setTotalAmountLocal(domainObject.getTotalAmountLocal());
        dataObject.setTotalAmountSystem(domainObject.getTotalAmountSystem());
        dataObject.setTotalAmountTransaction(domainObject.getTotalAmountTransaction());
        dataObject.setTotalCommissionLocal(domainObject.getTotalCommissionLocal());
        dataObject.setTotalCommissionSystem(dataObject.getTotalCommissionSystem());
        dataObject.setTotalCommissionTransaction(domainObject.getTotalCommissionTransaction());
        return super.updateDataObjectDepth0Fields(domainObject, dataObject);
    }

    @Override
    protected local.tin.tests.jpa.workshop.copy.values.model.domain.BookingProductItem updateDomainObjectDepth0Fields(local.tin.tests.jpa.workshop.copy.values.model.domain.BookingProductItem domainObject, BookingProductItem dataObject) throws DAOException {
        domainObject.setBooking(dataObject.getBooking());
        domainObject.setBookingProductReference(dataObject.getBookingProductReference());
        domainObject.setCancelAmountTransaction(dataObject.getCancelAmountTransaction());
        domainObject.setCancellationPolicyRuleId(dataObject.getCancellationPolicyRuleId());
        domainObject.setCurrencyCodeLocal(dataObject.getCurrencyCodeLocal());
        domainObject.setCurrencyCodeSystem(dataObject.getCurrencyCodeSystem());
        domainObject.setCurrencyCodeTransaction(dataObject.getCurrencyCodeTransaction());
        domainObject.setInvoiceDate(dataObject.getInvoiceDate());
        domainObject.setProductId(dataObject.getProductId());
        domainObject.setProductName(dataObject.getProductName());
        domainObject.setSellerCompanyId(dataObject.getSellerCompanyId());
        domainObject.setSendNewUserBookingNotification(dataObject.getSendNewUserBookingNotification());
        domainObject.setTaxId(dataObject.getTaxId());
        domainObject.setTotalAmountLocal(dataObject.getTotalAmountLocal());
        domainObject.setTotalAmountSystem(dataObject.getTotalAmountSystem());
        domainObject.setTotalAmountTransaction(dataObject.getTotalAmountTransaction());
        domainObject.setTotalCommissionLocal(dataObject.getTotalCommissionLocal());
        domainObject.setTotalCommissionSystem(dataObject.getTotalCommissionSystem());
        domainObject.setTotalCommissionTransaction(dataObject.getTotalCommissionTransaction());
        return super.updateDomainObjectDepth0Fields(domainObject, dataObject);
    }

    @Override
    protected local.tin.tests.jpa.workshop.copy.values.model.domain.BookingProductItem updateDomainObjectDeeperFields(local.tin.tests.jpa.workshop.copy.values.model.domain.BookingProductItem domainObject, BookingProductItem dataObject, int depth) throws DAOException {
        BookingCommissionItemDAO bookingCommissionItemDAO = (BookingCommissionItemDAO) CopyValuesDAOFactory.getInstance().getDAO(local.tin.tests.jpa.workshop.copy.values.model.domain.BookingCommissionItem.class);
        for (BookingCommissionItem current : dataObject.getBookingCommissionItems()) {
            domainObject.getBookingCommissionItems().add(bookingCommissionItemDAO.getDomainObject(current, depth));
        }
        return super.updateDomainObjectDeeperFields(domainObject, dataObject, depth);
    }

    @Override
    public Collection<local.tin.tests.jpa.workshop.copy.values.model.domain.BookingProductItem> retrieveAllWithCommission() throws DAOException {
        EntityManager entityManager = getEntityManager();
        Collection<local.tin.tests.jpa.workshop.copy.values.model.domain.BookingProductItem> results = new HashSet<>();
        try {
            Collection<BookingProductItem> dataObjects = retrieveAllWithCommission(entityManager);
            for (BookingProductItem current : dataObjects) {
                results.add(getDomainObject(current, DEFAULT_DEPTH_ENTITY));
            }
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return results;
    }

    protected Collection<BookingProductItem> retrieveAllWithCommission(EntityManager entityManager) throws DAOException {
        Query query = entityManager.createQuery(QUERY_WITH_COMMISSION);
        return query.getResultList();
    }

}
