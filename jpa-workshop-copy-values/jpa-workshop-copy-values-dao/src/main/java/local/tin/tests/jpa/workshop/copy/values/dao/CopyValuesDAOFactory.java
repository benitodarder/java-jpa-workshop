package local.tin.tests.jpa.workshop.copy.values.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import local.tin.tests.jpa.workshop.dao.impl.AbstractDAOFactory;
import local.tin.tests.jpa.workshop.model.domain.exceptions.DAOException;
import org.apache.log4j.Logger;

public class CopyValuesDAOFactory extends AbstractDAOFactory {

    public static final String UNEXPECTED_DAO_EXCEPTION_CREATING_ENTITY_M = "Unexpected DAOException creating entity manager factory: ";    
    private static final Object LOCK = new Object();
    private static final Logger LOGGER = Logger.getLogger(CopyValuesDAOFactory.class);
    private static volatile EntityManagerFactory entityManagerFactory;

    private CopyValuesDAOFactory() {
    }

    private static class Loader {

        protected static final CopyValuesDAOFactory INSTANCE = new CopyValuesDAOFactory();

        private Loader() {
        }
    }

    public static CopyValuesDAOFactory getInstance() {
        CopyValuesDAOFactory receiptDAOFactory = Loader.INSTANCE;
        EntityManagerFactory emf = entityManagerFactory;
        if (emf == null) {
            synchronized (LOCK) {
                emf = entityManagerFactory;
                if (emf == null) {
                    try {
                        entityManagerFactory = Persistence.createEntityManagerFactory(CopyValuesDAOConfiguration.getInstance().getPersistenceUnit());
                    } catch (DAOException ex) {
                        LOGGER.error(UNEXPECTED_DAO_EXCEPTION_CREATING_ENTITY_M + ex.getLocalizedMessage());
                        LOGGER.debug(UNEXPECTED_DAO_EXCEPTION_CREATING_ENTITY_M + ex.getLocalizedMessage(), ex);
                    }
                }
            }
        }
        return receiptDAOFactory;

    }

    @Override
    protected EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    @Override
    protected String getDAOBasePackage() throws DAOException {
        return CopyValuesDAOConfiguration.getInstance().getDAOBasePackage();
    }

    @Override
    protected Logger getLogger() {
        return LOGGER;
    }

}
