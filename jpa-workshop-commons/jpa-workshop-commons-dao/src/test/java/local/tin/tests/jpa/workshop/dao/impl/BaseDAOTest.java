package local.tin.tests.jpa.workshop.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author benitodarder
 */
public abstract class BaseDAOTest {

    protected static final int ID = 666;
    protected static final String NAME = "name";
    protected static Logger mockedLogger;
    protected static EntityManagerFactory mockedEntityManagerFactory;
    protected EntityManager mockedEntityManager;
    protected EntityTransaction mockedEntityTransaction;

    @BeforeClass
    public static void setUpClass() {
        mockedEntityManagerFactory = mock(EntityManagerFactory.class);
        mockedLogger = mock(Logger.class);
    }

    protected void setUpBaseMocks() {
        mockedEntityManager = mock(EntityManager.class);
        when(mockedEntityManagerFactory.createEntityManager()).thenReturn(mockedEntityManager);
    }

}
