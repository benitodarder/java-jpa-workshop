package local.tin.tests.jpa.workshop.copy.values.app;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import local.tin.tests.jpa.common.core.files.ResourcesUtils;
import local.tin.tests.jpa.workshop.copy.values.dao.CopyValuesDAOConfiguration;
import local.tin.tests.jpa.workshop.copy.values.dao.CopyValuesDAOFactory;
import local.tin.tests.jpa.workshop.copy.values.dao.impl.BookingCommissionItemDAO;
import local.tin.tests.jpa.workshop.copy.values.dao.impl.BookingProductItemDAO;
import local.tin.tests.jpa.workshop.copy.values.model.domain.BookingCommissionItem;
import local.tin.tests.jpa.workshop.copy.values.model.domain.BookingProductItem;
import local.tin.tests.jpa.workshop.model.domain.exceptions.DAOException;
import org.apache.log4j.Logger;

/**
 *
 * @author benitodarder
 */
public class CopyOneBookingProductItem {

    private static final Logger LOGGER = Logger.getLogger(CopyOneBookingProductItem.class);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, DAOException, Exception {
        LOGGER.info("Let's do some console DAO tests!");
        if (args.length == 1) {
            Properties properties = ResourcesUtils.getInstance().getPropertiesFile(CopyOneBookingProductItem.class, "dao.properties");
            CopyValuesDAOConfiguration.getInstance().loadProperties(properties);
            BookingProductItemDAO productDAO = (BookingProductItemDAO) CopyValuesDAOFactory.getInstance().getDAO(BookingProductItem.class);
            BookingProductItem master = productDAO.retrieve(Integer.valueOf(args[0]));
            if (master != null && master.getTotalCommissionLocal() != null && master.getTotalCommissionSystem() != null && master.getTotalCommissionTransaction() != null) {
                LOGGER.info("We got: " + master);
                BookingCommissionItem bookingCommissionItem = new BookingCommissionItem();
                bookingCommissionItem.setBookingDate(master.getBookingDate());
                bookingCommissionItem.setBookingProductItem(master);
                bookingCommissionItem.setCancelDate(master.getCancelDate());
                bookingCommissionItem.setCurrencyCodeLocal(master.getCurrencyCodeLocal());
                bookingCommissionItem.setCurrencyCodeSystem(master.getCurrencyCodeSystem());
                bookingCommissionItem.setCurrencyCodeTransaction(master.getCurrencyCodeTransaction());
                bookingCommissionItem.setDbUserIns(master.getDbUserIns());
                bookingCommissionItem.setDbUserUpdate(master.getDbUserUpdate());
                bookingCommissionItem.setGdStatus(master.getGdStatus());
                bookingCommissionItem.setGdStatusFlowType(master.getGdStatusFlowType());
                bookingCommissionItem.setIdUserInsert(master.getIdUserInsert());
                bookingCommissionItem.setIdUserUpdate(master.getIdUserUpdate());
                bookingCommissionItem.setInsertDate(master.getInsertDate());
                bookingCommissionItem.setModifyDate(master.getModifyDate());
                bookingCommissionItem.setTotalCommissionLocal(master.getTotalCommissionLocal());
                bookingCommissionItem.setTotalCommissionSystem(master.getTotalCommissionSystem());
                bookingCommissionItem.setTotalCommissionTransaction(master.getTotalCommissionTransaction());
                BookingCommissionItemDAO secondaryDAO = (BookingCommissionItemDAO) CopyValuesDAOFactory.getInstance().getDAO(BookingCommissionItem.class);
                secondaryDAO.create(bookingCommissionItem);
                List<BookingCommissionItem> products = secondaryDAO.retrieveAll();
                LOGGER.info("We got: " + products.size() + " BookingCommissionItem items");
                for (BookingCommissionItem current : products) {
                    LOGGER.info(current);
                }
                master = productDAO.retrieve(Integer.valueOf(args[0]));                
                LOGGER.info("And BookingProductItem is now: " + master);
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
