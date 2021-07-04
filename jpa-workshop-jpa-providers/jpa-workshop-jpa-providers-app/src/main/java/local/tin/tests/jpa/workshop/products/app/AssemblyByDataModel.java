package local.tin.tests.jpa.workshop.products.app;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import local.tin.tests.jpa.common.core.files.ResourcesUtils;
import local.tin.tests.jpa.workshop.dao.ProductDAOConfiguration;
import local.tin.tests.jpa.workshop.model.domain.exceptions.DAOException;
import org.apache.log4j.Logger;

/**
 *
 * @author benitodarder
 */
public class AssemblyByDataModel {

    private static final Logger LOGGER = Logger.getLogger(AssemblyByDataModel.class);

    /**
     * @param args the command line arguments
     * @throws local.tin.tests.jpa.workshop.model.domain.exceptions.DAOException
     */
    public static void main(String[] args) throws DAOException, IOException {
        EntityManager entityManager = null;
        try {
            Properties properties = ResourcesUtils.getInstance().getPropertiesFile(AssemblyByDataModel.class, "dao.properties");
            ProductDAOConfiguration.getInstance().loadProperties(properties);
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(ProductDAOConfiguration.getInstance().getPersistenceUnit());
            entityManager = entityManagerFactory.createEntityManager();
            Query typedQuery = entityManager.createQuery("select a from Assembly a");
            List<local.tin.tests.jpa.workshop.model.data.product.Assembly> dataAsemblies = typedQuery.getResultList();
            for (local.tin.tests.jpa.workshop.model.data.product.Assembly current : dataAsemblies) {
                LOGGER.info("Assembly:");
                LOGGER.info("\tId: {" + current.getId().getProductId() + ", " + current.getId().getComponentId() + "}");
                LOGGER.info("\tQuantity: " + current.getQuantity());
                LOGGER.info("\tProduct:");
                LOGGER.info("\t\t Id: " + current.getProduct().getId());
                LOGGER.info("\t\t Name: " + current.getProduct().getName());
                LOGGER.info("\tComponent:");
                LOGGER.info("\t\tId: " + current.getComponent().getId());
                LOGGER.info("\t\tName: " + current.getComponent().getName());
            }
            LOGGER.info("That's all folks!");
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    private static String getAssembly(local.tin.tests.jpa.workshop.model.data.product.Assembly assembly) {
        return "Assembly{" + "id=" + assembly.getId() + ", quantity=" + assembly.getQuantity() + ", product id.=" + assembly.getProduct().getId() + ", component id=" + assembly.getComponent().getId() + '}';
    }

}
