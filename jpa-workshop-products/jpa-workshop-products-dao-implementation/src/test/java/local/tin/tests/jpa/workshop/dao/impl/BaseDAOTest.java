package local.tin.tests.jpa.workshop.dao.impl;

import local.tin.tests.jpa.workshop.dao.impl.AssemblyDAO;
import local.tin.tests.jpa.workshop.dao.impl.ComponentDAO;
import local.tin.tests.jpa.workshop.dao.impl.ProductDAOFactory;
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
@PrepareForTest({ProductDAOFactory.class})
public abstract class BaseDAOTest {


    protected static final int ID = 666;
    protected static final String NAME = "name";
    protected static ProductDAOFactory mockedDAOFactory;        
    protected static EntityManagerFactory mockedEntityManagerFactory;
    protected EntityManager mockedEntityManager;
    protected AssemblyDAO mockedAssemblyDAO;
    protected local.tin.tests.jpa.workshop.model.domain.product.Assembly mockedDomainAssembly;
    protected local.tin.tests.jpa.workshop.model.data.product.Assembly mockedDataAssembly;
    protected ComponentDAO mockedComponentDAO;
    protected local.tin.tests.jpa.workshop.model.domain.product.Component mockedDomainComponent;
    protected local.tin.tests.jpa.workshop.model.data.product.Component mockedDataComponent;    
    
    @BeforeClass
    public static void setUpClass() {
        mockedDAOFactory = mock(ProductDAOFactory.class);
        mockedEntityManagerFactory = mock(EntityManagerFactory.class);        
    }
        
    
    protected void setUpBaseMocks() {
        mockedEntityManager = mock(EntityManager.class);
        when(mockedEntityManagerFactory.createEntityManager()).thenReturn(mockedEntityManager);
        PowerMockito.mockStatic(ProductDAOFactory.class);
        when(ProductDAOFactory.getInstance()).thenReturn(mockedDAOFactory);            
    }
    
    protected void setAssemblyMocks() throws DAOException {
        mockedAssemblyDAO = mock(AssemblyDAO.class);
        when(mockedDAOFactory.getDAO(local.tin.tests.jpa.workshop.model.data.product.Assembly.class)).thenReturn(mockedAssemblyDAO);
        mockedDomainAssembly = mock(local.tin.tests.jpa.workshop.model.domain.product.Assembly.class);
        mockedDataAssembly = mock(local.tin.tests.jpa.workshop.model.data.product.Assembly.class);
        when(mockedAssemblyDAO.getDataObject(eq(mockedDomainAssembly), anyInt())).thenReturn(mockedDataAssembly);
        when(mockedAssemblyDAO.getDomainObject(eq(mockedDataAssembly), anyInt())).thenReturn(mockedDomainAssembly);
    }    
    
    protected void setComponentMocks() throws DAOException {
        mockedComponentDAO = mock(ComponentDAO.class);
        when(mockedDAOFactory.getDAO(local.tin.tests.jpa.workshop.model.data.product.Component.class)).thenReturn(mockedComponentDAO);
        mockedDomainComponent = mock(local.tin.tests.jpa.workshop.model.domain.product.Component.class);
        mockedDataComponent = mock(local.tin.tests.jpa.workshop.model.data.product.Component.class);
        when(mockedComponentDAO.getDataObject(eq(mockedDomainComponent), anyInt())).thenReturn(mockedDataComponent);
        when(mockedComponentDAO.getDomainObject(eq(mockedDataComponent), anyInt())).thenReturn(mockedDomainComponent);        
    }    
}
