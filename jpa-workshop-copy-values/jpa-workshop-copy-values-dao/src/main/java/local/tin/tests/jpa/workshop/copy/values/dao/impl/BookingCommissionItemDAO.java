package local.tin.tests.jpa.workshop.copy.values.dao.impl;

import javax.persistence.EntityManagerFactory;
import local.tin.tests.jpa.workshop.copy.values.dao.CopyValuesDAOFactory;
import local.tin.tests.jpa.workshop.copy.values.model.data.BookingCommissionItem;
import local.tin.tests.jpa.workshop.copy.values.model.domain.BookingProductItem;
import local.tin.tests.jpa.workshop.model.domain.exceptions.DAOException;

/**
 *
 * @author benitodarder
 */
public class BookingCommissionItemDAO extends BookingItemDAO<local.tin.tests.jpa.workshop.copy.values.model.domain.BookingCommissionItem, BookingCommissionItem> {

    public BookingCommissionItemDAO(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory);
    }

    @Override
    protected Class<BookingCommissionItem> getDAOClass() {
        return BookingCommissionItem.class;
    }

    @Override
    protected local.tin.tests.jpa.workshop.copy.values.model.domain.BookingCommissionItem getDomainObjectNewInstance() {
        return new local.tin.tests.jpa.workshop.copy.values.model.domain.BookingCommissionItem();
    }

    @Override
    protected BookingCommissionItem getDataObjectNewInstance() {
        return new BookingCommissionItem();
    }

    @Override
    protected BookingCommissionItem updateDataObjectDeeperFields(local.tin.tests.jpa.workshop.copy.values.model.domain.BookingCommissionItem domainObject, BookingCommissionItem dataObject, int depth) throws DAOException {
        BookingProductItemDAO bookingProductItemDAO = (BookingProductItemDAO) CopyValuesDAOFactory.getInstance().getDAO(local.tin.tests.jpa.workshop.copy.values.model.domain.BookingProductItem.class);
        dataObject.setBookingProductItem(bookingProductItemDAO.getDataObject(domainObject.getBookingProductItem(), depth));
        return super.updateDataObjectDeeperFields(domainObject, dataObject, depth); 
    }

    @Override
    protected BookingCommissionItem updateDataObjectDepth0Fields(local.tin.tests.jpa.workshop.copy.values.model.domain.BookingCommissionItem domainObject, BookingCommissionItem dataObject) throws DAOException {
        dataObject.setCurrencyCodeLocal(domainObject.getCurrencyCodeLocal());
        dataObject.setCurrencyCodeSystem(domainObject.getCurrencyCodeSystem());
        dataObject.setCurrencyCodeTransaction(domainObject.getCurrencyCodeTransaction());
        dataObject.setTotalCommissionLocal(domainObject.getTotalCommissionLocal());
        dataObject.setTotalCommissionSystem(dataObject.getTotalCommissionSystem());
        dataObject.setTotalCommissionTransaction(domainObject.getTotalCommissionTransaction());        
        return super.updateDataObjectDepth0Fields(domainObject, dataObject); 
    }

    @Override
    protected local.tin.tests.jpa.workshop.copy.values.model.domain.BookingCommissionItem updateDomainObjectDeeperFields(local.tin.tests.jpa.workshop.copy.values.model.domain.BookingCommissionItem domainObject, BookingCommissionItem dataObject, int depth) throws DAOException {     
        BookingProductItemDAO bookingProductItemDAO = (BookingProductItemDAO) CopyValuesDAOFactory.getInstance().getDAO(local.tin.tests.jpa.workshop.copy.values.model.domain.BookingProductItem.class);
        domainObject.setBookingProductItem(bookingProductItemDAO.getDomainObject(dataObject.getBookingProductItem(), depth));
        return super.updateDomainObjectDeeperFields(domainObject, dataObject, depth); 
    }

    @Override
    protected local.tin.tests.jpa.workshop.copy.values.model.domain.BookingCommissionItem updateDomainObjectDepth0Fields(local.tin.tests.jpa.workshop.copy.values.model.domain.BookingCommissionItem domainObject, BookingCommissionItem dataObject) throws DAOException {
        domainObject.setCurrencyCodeLocal(dataObject.getCurrencyCodeLocal());
        domainObject.setCurrencyCodeSystem(dataObject.getCurrencyCodeSystem());
        domainObject.setCurrencyCodeTransaction(dataObject.getCurrencyCodeTransaction());
        domainObject.setTotalCommissionLocal(dataObject.getTotalCommissionLocal());
        domainObject.setTotalCommissionSystem(dataObject.getTotalCommissionSystem());
        domainObject.setTotalCommissionTransaction(dataObject.getTotalCommissionTransaction());           
        return super.updateDomainObjectDepth0Fields(domainObject, dataObject); 
    }
    
    
    
}
