package local.tin.tests.jpa.workshop.copy.values.app;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import local.tin.tests.jpa.common.core.files.ResourcesUtils;
import local.tin.tests.jpa.workshop.copy.values.dao.CopyValuesDAOConfiguration;
import local.tin.tests.jpa.workshop.copy.values.dao.CopyValuesDAOFactory;
import local.tin.tests.jpa.workshop.copy.values.dao.impl.MasterFromBaseDAO;
import local.tin.tests.jpa.workshop.copy.values.dao.impl.SecondaryFromBaseDAO;
import local.tin.tests.jpa.workshop.copy.values.model.domain.MasterFromBase;
import local.tin.tests.jpa.workshop.copy.values.model.domain.SecondaryFromBase;
import local.tin.tests.jpa.workshop.model.domain.exceptions.DAOException;
import org.apache.log4j.Logger;

/**
 *
 * @author benitodarder
 */
public class CopyOneMasterFromBase {

    private static final Logger LOGGER = Logger.getLogger(CopyOneMasterFromBase.class);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, DAOException, Exception {
        LOGGER.info("Let's do some console DAO tests!");
        if (args.length == 1) {
            Properties properties = ResourcesUtils.getInstance().getPropertiesFile(CopyOneMasterFromBase.class, "dao.properties");
            CopyValuesDAOConfiguration.getInstance().loadProperties(properties);
            MasterFromBaseDAO productDAO = (MasterFromBaseDAO) CopyValuesDAOFactory.getInstance().getDAO(MasterFromBase.class);
            MasterFromBase master = productDAO.retrieve(Integer.valueOf(args[0]));
            if (master != null) {
                SecondaryFromBase secondary = new SecondaryFromBase();
                secondary.setEnabled(master.isEnabled());
                secondary.setMasterFromBase(master);
                secondary.setName("SecondaryFromBase of " + master.getName());
                secondary.setValue02(master.getValue02());
                secondary.setValue03(master.getValue03());
                secondary.setCommonValue(master.getCommonValue());
                SecondaryFromBaseDAO secondaryDAO = (SecondaryFromBaseDAO) CopyValuesDAOFactory.getInstance().getDAO(SecondaryFromBase.class);
                secondaryDAO.create(secondary);
                List<SecondaryFromBase> products = secondaryDAO.retrieveAll();
                LOGGER.info("We got: " + products.size() + " SecondaryFromBase items");
                for (SecondaryFromBase current : products) {
                    LOGGER.info(current);
                }                
            } else {
                LOGGER.info("Could not find a MasterFromBase with id: " + args[0]);
            }
            CopyValuesDAOFactory.getInstance().closeEntityManagerFactory();
        } else {
            LOGGER.info("CopyOneMasterFromBase <id to copy>");
        }
        LOGGER.info("That's all folks!");
    }

}
