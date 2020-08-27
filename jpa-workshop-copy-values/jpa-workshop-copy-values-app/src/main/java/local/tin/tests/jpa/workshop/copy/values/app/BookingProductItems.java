package local.tin.tests.jpa.workshop.copy.values.app;

import org.apache.log4j.Logger;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Properties;
import local.tin.tests.jpa.common.core.files.ResourcesUtils;
import local.tin.tests.jpa.workshop.copy.values.dao.CopyValuesDAOConfiguration;
import local.tin.tests.jpa.workshop.copy.values.dao.CopyValuesDAOFactory;
import local.tin.tests.jpa.workshop.copy.values.dao.impl.BookingProductItemDAO;
import local.tin.tests.jpa.workshop.copy.values.model.domain.BookingProductItem;
import local.tin.tests.jpa.workshop.model.domain.exceptions.DAOException;

/**
 *
 * @author benitodarder
 */
public class BookingProductItems {

    private static final Logger LOGGER = Logger.getLogger(BookingProductItems.class);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, DAOException, Exception {
        LOGGER.info("Let's do some console DAO tests!");
        Properties properties = ResourcesUtils.getInstance().getPropertiesFile(BookingProductItems.class, "dao.properties");
        CopyValuesDAOConfiguration.getInstance().loadProperties(properties);
        BookingProductItemDAO productDAO = (BookingProductItemDAO) CopyValuesDAOFactory.getInstance().getDAO(BookingProductItem.class);
        Collection<BookingProductItem> products = productDAO.retrieveAll();
        LOGGER.info("We got: " + products.size() + " BookingProductItem items");
        for (BookingProductItem current : products) {
            LOGGER.info(current);
        }
        products = productDAO.retrieveAllWithCommission();
        LOGGER.info("We got: " + products.size() + " BookingProductItem items with commssion");
        for (BookingProductItem current : products) {
            LOGGER.info(current);
        }        
        CopyValuesDAOFactory.getInstance().closeEntityManagerFactory();
        LOGGER.info("That's all folks!");
    }

}

