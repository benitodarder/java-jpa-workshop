package local.tin.tests.jpa.workshop.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import static local.tin.tests.jpa.workshop.dao.impl.AbstractDAOTest.mockedAbstractDataObject;
import local.tin.tests.jpa.workshop.model.data.interfaces.IIdentifiable;
import local.tin.tests.jpa.workshop.model.domain.exceptions.DAOException;
import local.tin.tests.jpa.workshop.model.data.interfaces.IEnableable;
import local.tin.tests.jpa.workshop.model.domain.Pagination;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 *
 * @author benitodarder
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({Logger.class, EntityManager.class, IllegalArgumentException.class, IIdentifiable.class})
public class AbstractEnableableDAOTest extends BaseDAOTest {
    
    protected static local.tin.tests.jpa.workshop.model.data.interfaces.IEnableable mockedAbstractDataObject;
    protected static local.tin.tests.jpa.workshop.model.domain.interfaces.IEnableable mockedAbstractDomainObject;
    private AbstractEnableableDAO dao;
    
   @BeforeClass
    public static void setUpClass() {
        BaseDAOTest.setUpClass();
        mockedAbstractDataObject = mock(IEnableable.class);
        mockedAbstractDomainObject = mock(local.tin.tests.jpa.workshop.model.domain.interfaces.IEnableable.class);
    }    
  
    @Before
    public void setUp() {
        setUpBaseMocks();
        PowerMockito.mockStatic(Logger.class);
        when(Logger.getLogger(AbstractDAO.class)).thenReturn(mockedLogger);        
        mockedEntityTransaction = mock(EntityTransaction.class);
        when(mockedEntityManager.getTransaction()).thenReturn(mockedEntityTransaction);
        dao = new AbstractEnableableDAOWrapper(mockedEntityManagerFactory);
        reset(mockedLogger);     
    }  
    
    
    @Test
    public void updateDomainCommonFields_assigns_fields() throws DAOException {
        when(mockedAbstractDataObject.isEnabled()).thenReturn(true);

        dao.updateDomainCommonFields(mockedAbstractDomainObject, mockedAbstractDataObject);

        verify(mockedAbstractDomainObject).setEnabled(true);
    }

    @Test
    public void updateDataCommonFields_assigns_fields() throws DAOException {
        when(mockedAbstractDomainObject.isEnabled()).thenReturn(true);

        dao.updateDataCommonFields(mockedAbstractDomainObject, mockedAbstractDataObject);

        verify(mockedAbstractDataObject).setEnabled(true);
    }    
}

class AbstractEnableableDAOWrapper extends AbstractEnableableDAO<local.tin.tests.jpa.workshop.model.domain.interfaces.IEnableable, local.tin.tests.jpa.workshop.model.data.interfaces.IEnableable> {

    public AbstractEnableableDAOWrapper(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory);
    }

    @Override
    protected Class<IEnableable> getDAOClass() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected local.tin.tests.jpa.workshop.model.domain.interfaces.IEnableable getDomainObjectNewInstance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected IEnableable getDataObjectNewInstance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected local.tin.tests.jpa.workshop.model.domain.interfaces.IEnableable updateDomainObjectDepth0Fields(local.tin.tests.jpa.workshop.model.domain.interfaces.IEnableable domainObject, IEnableable dataObject) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected local.tin.tests.jpa.workshop.model.domain.interfaces.IEnableable updateDomainObjectDeeperFields(local.tin.tests.jpa.workshop.model.domain.interfaces.IEnableable domainObject, IEnableable dataObject, int depth) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected IEnableable updateDataObjectDepth0Fields(local.tin.tests.jpa.workshop.model.domain.interfaces.IEnableable domainObject, IEnableable dataObject) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected IEnableable updateDataObjectDeeperFields(local.tin.tests.jpa.workshop.model.domain.interfaces.IEnableable domainObject, IEnableable dataObject, int depth) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}