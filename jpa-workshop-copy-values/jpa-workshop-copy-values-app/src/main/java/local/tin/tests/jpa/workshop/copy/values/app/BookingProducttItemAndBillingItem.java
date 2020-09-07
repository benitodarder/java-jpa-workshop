package local.tin.tests.jpa.workshop.copy.values.app;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Properties;
import local.tin.tests.jpa.common.core.files.ResourcesUtils;
import local.tin.tests.jpa.workshop.copy.values.dao.CopyValuesDAOConfiguration;
import local.tin.tests.jpa.workshop.copy.values.dao.CopyValuesDAOFactory;
import local.tin.tests.jpa.workshop.copy.values.dao.impl.BillingItemDAO;
import local.tin.tests.jpa.workshop.copy.values.dao.impl.BookingCommissionItemDAO;
import local.tin.tests.jpa.workshop.copy.values.dao.impl.BookingProductItemDAO;
import local.tin.tests.jpa.workshop.copy.values.model.domain.BillingItem;
import local.tin.tests.jpa.workshop.copy.values.model.domain.BookingCommissionItem;
import local.tin.tests.jpa.workshop.copy.values.model.domain.BookingProductItem;
import local.tin.tests.jpa.workshop.model.domain.exceptions.DAOException;
import org.apache.log4j.Logger;

/**
 *
 * @author benitodarder
 */
public class BookingProducttItemAndBillingItem {

    private static final Logger LOGGER = Logger.getLogger(BookingProducttItemAndBillingItem.class);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, DAOException, Exception {
        LOGGER.info("Let's do some console DAO tests!");
        if (args.length == 1) {
            Properties properties = ResourcesUtils.getInstance().getPropertiesFile(BookingProducttItemAndBillingItem.class, "dao.properties");
            CopyValuesDAOConfiguration.getInstance().loadProperties(properties);
            BookingProductItemDAO productDAO = (BookingProductItemDAO) CopyValuesDAOFactory.getInstance().getDAO(BookingProductItem.class);
            BookingProductItem master = productDAO.retrieve(Integer.valueOf(args[0]));
            if (master != null && master.getTotalCommissionLocal() != null && master.getTotalCommissionSystem() != null && master.getTotalCommissionTransaction() != null) {
                LOGGER.info("We got the BookingProductItem: " + master);
                BillingItemDAO billingItemDAO = (BillingItemDAO) CopyValuesDAOFactory.getInstance().getDAO(BillingItem.class);
                Collection<BillingItem> billingItems = billingItemDAO.retrieveByBookingItem((Integer) master.getId());
                LOGGER.info("We got the BillingItems: ");
                for (BillingItem current : billingItems) {
                    LOGGER.info(current);
                }
            } else {
                LOGGER.info("MasterFromBase with id: " + args[0] + ", not suitable for copy, not found or without commissions");
            }
            CopyValuesDAOFactory.getInstance().closeEntityManagerFactory();
        } else {
            LOGGER.info("CopyOneMasterFromBase <id to copy>");
        }
        LOGGER.info("That's all folks!");
    }

}
