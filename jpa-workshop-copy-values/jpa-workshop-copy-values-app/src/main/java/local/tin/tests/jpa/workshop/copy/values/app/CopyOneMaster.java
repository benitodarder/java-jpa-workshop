package local.tin.tests.jpa.workshop.copy.values.app;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import local.tin.tests.jpa.common.core.files.ResourcesUtils;
import local.tin.tests.jpa.workshop.copy.values.dao.CopyValuesDAOConfiguration;
import local.tin.tests.jpa.workshop.copy.values.dao.CopyValuesDAOFactory;
import local.tin.tests.jpa.workshop.copy.values.dao.impl.MasterDAO;
import local.tin.tests.jpa.workshop.copy.values.dao.impl.SecondaryDAO;
import local.tin.tests.jpa.workshop.copy.values.model.domain.Master;
import local.tin.tests.jpa.workshop.copy.values.model.domain.Secondary;
import local.tin.tests.jpa.workshop.model.domain.exceptions.DAOException;
import org.apache.log4j.Logger;

/**
 *
 * @author benitodarder
 */
public class CopyOneMaster {

    private static final Logger LOGGER = Logger.getLogger(CopyOneMaster.class);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, DAOException, Exception {
        LOGGER.info("Let's do some console DAO tests!");
        if (args.length == 1) {
            Properties properties = ResourcesUtils.getInstance().getPropertiesFile(Masters.class, "dao.properties");
            CopyValuesDAOConfiguration.getInstance().loadProperties(properties);
            MasterDAO productDAO = (MasterDAO) CopyValuesDAOFactory.getInstance().getDAO(Master.class);
            Master master = productDAO.retrieve(Integer.valueOf(args[0]));
            if (master != null) {
                Secondary secondary = new Secondary();
                secondary.setEnabled(master.isEnabled());
                secondary.setMaster(master);
                secondary.setName("Secondary of " + master.getName());
                secondary.setValue02(master.getValue02());
                secondary.setValue03(master.getValue03());
                SecondaryDAO secondaryDAO = (SecondaryDAO) CopyValuesDAOFactory.getInstance().getDAO(Secondary.class);
                secondaryDAO.create(secondary);
                List<Secondary> products = secondaryDAO.retrieveAll();
                LOGGER.info("We got: " + products.size() + " Secondary items");
                for (Secondary current : products) {
                    LOGGER.info(current);
                }                
            } else {
                LOGGER.info("Could not find a Master with id: " + args[0]);
            }
        } else {
            LOGGER.info("CopyOneMaster <id to copy>");
        }
        LOGGER.info("That's all folks!");
    }

}
