package local.tin.tests.jpa.workshop.copy.values.app;

import org.apache.log4j.Logger;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Properties;
import local.tin.tests.jpa.common.core.files.ResourcesUtils;
import local.tin.tests.jpa.workshop.copy.values.dao.CopyValuesDAOConfiguration;
import local.tin.tests.jpa.workshop.copy.values.dao.CopyValuesDAOFactory;
import local.tin.tests.jpa.workshop.copy.values.dao.impl.BillingItemDAO;
import local.tin.tests.jpa.workshop.copy.values.model.domain.BillingItem;
import local.tin.tests.jpa.workshop.model.domain.exceptions.DAOException;

/**
 *
 * @author benitodarder
 */
public class BillingItems {

    private static final Logger LOGGER = Logger.getLogger(BillingItems.class);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, DAOException, Exception {
        LOGGER.info("Let's do some console DAO tests!");
        Properties properties = ResourcesUtils.getInstance().getPropertiesFile(BillingItems.class, "dao.properties");
        CopyValuesDAOConfiguration.getInstance().loadProperties(properties);
        BillingItemDAO productDAO = (BillingItemDAO) CopyValuesDAOFactory.getInstance().getDAO(BillingItem.class);
        Collection<BillingItem> products = productDAO.retrieveAll();
        LOGGER.info("We got: " + products.size() + " BillingItem items");
        for (BillingItem current : products) {
            LOGGER.info(current);
        }        
        CopyValuesDAOFactory.getInstance().closeEntityManagerFactory();
        LOGGER.info("That's all folks!");
    }

}

