package local.tin.tests.jpa.workshop.create.load.schema.app;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import local.tin.tests.jpa.common.core.files.ResourcesUtils;
import local.tin.tests.jpa.common.core.xml.JAXBMarshaller;
import local.tin.tests.jpa.workshop.dao.ProductDAOConfiguration;
import local.tin.tests.jpa.workshop.dao.impl.ProductDAO;
import local.tin.tests.jpa.workshop.dao.impl.ProductDAOFactory;
import local.tin.tests.jpa.workshop.model.domain.exceptions.DAOException;
import local.tin.tests.jpa.workshop.model.domain.product.Product;
import org.apache.log4j.Logger;

/**
 *
 * @author benitodarder
 */
public class ProductsApp {

    private static final Logger LOGGER = Logger.getLogger(ProductsApp.class);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, DAOException, Exception {
        LOGGER.info("Let's do some console DAO tests!");
        Properties properties = ResourcesUtils.getInstance().getPropertiesFile(ProductsApp.class, "dao.properties");
        ProductDAOConfiguration.getInstance().loadProperties(properties);
        ProductDAO productDAO = (ProductDAO) ProductDAOFactory.getInstance().getDAO(Product.class);
        List<Product> products = productDAO.retrieveAll();
        LOGGER.info("We got: " + products.size() + " products");
        for (Product current : products) {
            LOGGER.info(JAXBMarshaller.getInstance().toString(current));
        }
        ProductDAOFactory.getInstance().closeEntityManagerFactory();
        LOGGER.info("That's all folks!");
    }

}
