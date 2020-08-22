package local.tin.tests.jpa.workshop.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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
    protected static EntityManagerFactory mockedEntityManagerFactory;
    protected EntityManager mockedEntityManager;
    
    @BeforeClass
    public static void setUpClass() {
        mockedEntityManagerFactory = mock(EntityManagerFactory.class);        
    }
        
    
    protected void setUpBaseMocks() {
        mockedEntityManager = mock(EntityManager.class);
        when(mockedEntityManagerFactory.createEntityManager()).thenReturn(mockedEntityManager);           
    }
      
}
