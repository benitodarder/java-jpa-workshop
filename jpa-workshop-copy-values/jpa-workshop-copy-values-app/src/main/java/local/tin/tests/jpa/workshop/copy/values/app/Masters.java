package local.tin.tests.jpa.workshop.copy.values.app;

import org.apache.log4j.Logger;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import local.tin.tests.jpa.common.core.files.ResourcesUtils;
import local.tin.tests.jpa.workshop.copy.values.dao.CopyValuesDAOConfiguration;
import local.tin.tests.jpa.workshop.copy.values.dao.CopyValuesDAOFactory;
import local.tin.tests.jpa.workshop.copy.values.dao.impl.MasterDAO;
import local.tin.tests.jpa.workshop.copy.values.model.domain.Master;
import local.tin.tests.jpa.workshop.model.domain.exceptions.DAOException;

/**
 *
 * @author benitodarder
 */
public class Masters {

    private static final Logger LOGGER = Logger.getLogger(Masters.class);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, DAOException, Exception {
        LOGGER.info("Let's do some console DAO tests!");
        Properties properties = ResourcesUtils.getInstance().getPropertiesFile(Masters.class, "dao.properties");
        CopyValuesDAOConfiguration.getInstance().loadProperties(properties);
        MasterDAO productDAO = (MasterDAO) CopyValuesDAOFactory.getInstance().getDAO(Master.class);
        List<Master> products = productDAO.retrieveAll();
        LOGGER.info("We got: " + products.size() + " Master items");
        for (Master current : products) {
            LOGGER.info(current);
        }
        LOGGER.info("That's all folks!");
    }

}

