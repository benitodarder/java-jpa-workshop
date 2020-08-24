package local.tin.tests.jpa.workshop.copy.values.app;

import org.apache.log4j.Logger;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import local.tin.tests.jpa.common.core.files.ResourcesUtils;
import local.tin.tests.jpa.workshop.copy.values.dao.CopyValuesDAOConfiguration;
import local.tin.tests.jpa.workshop.copy.values.dao.CopyValuesDAOFactory;
import local.tin.tests.jpa.workshop.copy.values.dao.impl.MasterFromBaseDAO;
import local.tin.tests.jpa.workshop.copy.values.model.domain.MasterFromBase;
import local.tin.tests.jpa.workshop.model.domain.exceptions.DAOException;

/**
 *
 * @author benitodarder
 */
public class CreateMultipleMastersFromBase {

    private static final Logger LOGGER = Logger.getLogger(CreateMultipleMastersFromBase.class);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, DAOException, Exception {
        LOGGER.info("Let's do some console DAO tests!");
        if (args.length == 1) {
            Properties properties = ResourcesUtils.getInstance().getPropertiesFile(CreateMultipleMastersFromBase.class, "dao.properties");
            CopyValuesDAOConfiguration.getInstance().loadProperties(properties);
            MasterFromBaseDAO productDAO = (MasterFromBaseDAO) CopyValuesDAOFactory.getInstance().getDAO(MasterFromBase.class);
            LOGGER.info("Lets create: " + args[0] + " MasterFromBase");
            for (int i = 0; i < Integer.valueOf(args[0]); i++) {
                MasterFromBase masterFromBase = new MasterFromBase();
                masterFromBase.setName("MasterFromBase " + i);
                masterFromBase.setCommonValue("CommonValue " + i);
                masterFromBase.setValue01(0d + i);
                masterFromBase.setValue02("Value02 " + i);
                masterFromBase.setValue03(0d + i);
                productDAO.create(masterFromBase);
            }
            CopyValuesDAOFactory.getInstance().closeEntityManagerFactory();
        }
        LOGGER.info("That's all folks!");
    }

}
