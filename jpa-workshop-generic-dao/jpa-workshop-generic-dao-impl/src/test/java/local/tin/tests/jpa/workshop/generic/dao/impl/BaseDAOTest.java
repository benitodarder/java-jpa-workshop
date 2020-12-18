package local.tin.tests.jpa.workshop.generic.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import local.tin.tests.jpa.workshop.model.domain.exceptions.DAOException;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 *
 * @author benitodarder
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({GenericDAOFactory.class})
public abstract class BaseDAOTest {


    protected static final int ID = 666;
    protected static final String NAME = "name";
        protected static final Long TIMESTAMP = 98211600000l;
    protected static GenericDAOFactory mockedDAOFactory;        
    protected static EntityManagerFactory mockedEntityManagerFactory;
    protected EntityManager mockedEntityManager;
    protected local.tin.tests.jpa.workshop.model.domain.product.Assembly mockedDomainAssembly;
    protected local.tin.tests.jpa.workshop.model.data.product.Assembly mockedDataAssembly;
    protected local.tin.tests.jpa.workshop.model.domain.product.Component mockedDomainComponent;
    protected local.tin.tests.jpa.workshop.model.data.product.Component mockedDataComponent;    
    
    @BeforeClass
    public static void setUpClass() {
        mockedDAOFactory = mock(GenericDAOFactory.class);
        mockedEntityManagerFactory = mock(EntityManagerFactory.class);        
    }
        
    
    protected void setUpBaseMocks() {
        mockedEntityManager = mock(EntityManager.class);
        when(mockedEntityManagerFactory.createEntityManager()).thenReturn(mockedEntityManager);
        PowerMockito.mockStatic(GenericDAOFactory.class);
        when(GenericDAOFactory.getInstance()).thenReturn(mockedDAOFactory);            
    }
    
  
}
