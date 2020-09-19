package local.tin.tests.jpa.workshop.copy.values.dao.interfaces;

import java.util.Collection;
import local.tin.tests.jpa.workshop.model.domain.exceptions.DAOException;

/**
 *
 * @author benitodarder
 */
public interface IBillingItemDAO {
    
    public Collection<local.tin.tests.jpa.workshop.copy.values.model.domain.BillingItem> retrieveByBookingItem(Integer bookingItemId) throws DAOException;
    
}
