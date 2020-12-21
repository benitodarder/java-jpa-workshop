package local.tin.tests.jpa.workshop.generic.dao.app;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import local.tin.tests.jpa.common.core.files.ResourcesUtils;
import local.tin.tests.jpa.common.core.xml.JAXBMarshaller;
import local.tin.tests.jpa.workshop.generic.dao.GenericDAOConfiguration;
import local.tin.tests.jpa.workshop.generic.dao.impl.ComponentDAO;
import local.tin.tests.jpa.workshop.generic.dao.impl.GenericDAOFactory;
import local.tin.tests.jpa.workshop.generic.dao.impl.UnitDAO;
import local.tin.tests.jpa.workshop.model.domain.Pagination;
import local.tin.tests.jpa.workshop.model.domain.exceptions.DAOException;
import local.tin.tests.jpa.workshop.model.domain.product.Component;
import local.tin.tests.jpa.workshop.model.domain.product.Unit;
import org.apache.log4j.Logger;

/**
 *
 * @author benitodarder
 */
public class UnitsApp {

    public static final int UNIT_ID = 4;
    private static final Logger LOGGER = Logger.getLogger(UnitsApp.class);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, DAOException, Exception {
        LOGGER.info("Let's do some console DAO tests!");
        Properties properties = ResourcesUtils.getInstance().getPropertiesFile(UnitsApp.class, "dao.properties");
        GenericDAOConfiguration.getInstance().loadProperties(properties);
        UnitDAO productDAO = (UnitDAO) GenericDAOFactory.getInstance().getDAO(Unit.class);
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
        LOGGER.info("Let's review unit with id: " + UNIT_ID);
        Unit unit = productDAO.retrieve(UNIT_ID);
        LOGGER.info(JAXBMarshaller.getInstance().toString(unit));
        LOGGER.info("Let's add a new component... Milk...");
        Component component = new Component();
        component.setName("Milk");
        component.setEnabled(true);
        unit.getComponents().add(component);
        LOGGER.info("Before update:");
        LOGGER.info(JAXBMarshaller.getInstance().toString(unit));
        LOGGER.info("AFter update:");
        productDAO.update(unit);
        LOGGER.info(JAXBMarshaller.getInstance().toString(unit));
        LOGGER.info("Let's also check the components:");
        ComponentDAO componentDAO = (ComponentDAO) GenericDAOFactory.getInstance().getDAO(Component.class);
        List<Component> components = componentDAO.retrieveAll();
        for (Component current : components) {
            LOGGER.info(JAXBMarshaller.getInstance().toString(current));
        }
        LOGGER.info("The component have not been created. Let's persist now the component...");
        component.setUnit(unit);
        componentDAO.create(component);
        LOGGER.info("And now let's check the unit after reloading from database");
        unit = productDAO.retrieve(UNIT_ID);
        LOGGER.info(JAXBMarshaller.getInstance().toString(unit));
        GenericDAOFactory.getInstance().closeEntityManagerFactory();
        LOGGER.info("That's all folks!");
    }

}
