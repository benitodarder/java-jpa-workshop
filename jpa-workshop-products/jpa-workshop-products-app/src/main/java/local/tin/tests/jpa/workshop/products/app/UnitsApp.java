package local.tin.tests.jpa.workshop.products.app;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import local.tin.tests.jpa.common.core.files.ResourcesUtils;
import local.tin.tests.jpa.common.core.xml.JAXBMarshaller;
import local.tin.tests.jpa.workshop.dao.ProductDAOConfiguration;
import local.tin.tests.jpa.workshop.dao.impl.ProductDAOFactory;
import local.tin.tests.jpa.workshop.dao.impl.UnitDAO;
import local.tin.tests.jpa.workshop.model.domain.Pagination;
import local.tin.tests.jpa.workshop.model.domain.exceptions.DAOException;
import local.tin.tests.jpa.workshop.model.domain.product.Unit;
import org.apache.log4j.Logger;

/**
 *
 * @author benitodarder
 */
public class UnitsApp {

    private static final Logger LOGGER = Logger.getLogger(UnitsApp.class);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, DAOException, Exception {
        LOGGER.info("Let's do some console DAO tests!");
        Properties properties = ResourcesUtils.getInstance().getPropertiesFile(UnitsApp.class, "dao.properties");
        ProductDAOConfiguration.getInstance().loadProperties(properties);
        UnitDAO productDAO = (UnitDAO) ProductDAOFactory.getInstance().getDAO(Unit.class);
        List<Unit> units = productDAO.retrieveAll();
        LOGGER.info("We got: " + units.size() + " units");
        for (Unit current : units) {
            LOGGER.info(JAXBMarshaller.getInstance().toString(current));
        }
        LOGGER.info("Let's paginate! Page size:" + (units.size() / 2) + ", page: 2");
        Pagination pagination = new Pagination(2, units.size() / 2);
        units = productDAO.retrieveAll(pagination);
        LOGGER.info("We got: " + units.size() + " units");
        for (Unit current : units) {
            LOGGER.info(JAXBMarshaller.getInstance().toString(current));
        }
        LOGGER.info("That's all folks!");
    }

}
