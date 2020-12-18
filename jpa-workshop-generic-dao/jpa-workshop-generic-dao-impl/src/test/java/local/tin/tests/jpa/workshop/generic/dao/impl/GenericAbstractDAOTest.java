package local.tin.tests.jpa.workshop.generic.dao.impl;

import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.EntityManagerFactory;
import local.tin.tests.jpa.workshop.generic.dao.tests.model.CompositeId;
import local.tin.tests.jpa.workshop.generic.dao.tests.model.DataClassEmbeddedId;
import local.tin.tests.jpa.workshop.generic.dao.tests.model.DataClassSimpleId;
import local.tin.tests.jpa.workshop.generic.dao.tests.model.DomainClassCompositeId;
import local.tin.tests.jpa.workshop.generic.dao.tests.model.DomainClassSimpleId;
import local.tin.tests.jpa.workshop.generic.dao.tests.model.EmbeddedId;
import local.tin.tests.jpa.workshop.model.data.interfaces.IEmbeddable;
import local.tin.tests.jpa.workshop.model.domain.exceptions.DAOException;
import local.tin.tests.jpa.workshop.model.domain.interfaces.ICompositeId;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 *
 * @author developer01
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({GenericDAOFactory.class})
public class GenericAbstractDAOTest extends BaseDAOTest {
    
    private static final int VERSION = 69;
    private static final int DB_ID_UPDATE = ID + ID + ID;
    private static final int DB_ID_INSERT = ID + ID;
    private static final String DB_USER_UPDATE = "DB user update";
    private static final String DB_USER_INSERT = "DB user insert";    
    private static GenericDAOFactory mockedGenericDAOFactory;
    private DataClassSimpleId dataClassSimpleId;
    private DomainClassSimpleId domainClassSimpleId;
    private DataClassEmbeddedId dataClassEmbeddedId;
    private DomainClassCompositeId domainClassCompositeId;   
    private EmbeddedId embeddedId;
    private CompositeId compositeId;
    private GenericAbstractDAO dao;
    
    @BeforeClass
    public static void setUpClass() {
        BaseDAOTest.setUpClass();
        mockedGenericDAOFactory = mock(GenericDAOFactory.class);
    }
    
    @Before
    public void setUp() {
        super.setUpBaseMocks();
        dao = new GenericAbstractDAOWrapper(mockedEntityManagerFactory);
        PowerMockito.mockStatic(GenericDAOFactory.class);
        when(GenericDAOFactory.getInstance()).thenReturn(mockedGenericDAOFactory);
    }
    
    private void setDataClassSimpleId() {
        dataClassSimpleId = new DataClassSimpleId();
        dataClassSimpleId.setName(NAME);
        dataClassSimpleId.setEnabled(true);
        dataClassSimpleId.setId(ID);
        dataClassSimpleId.setDate(new java.sql.Date(TIMESTAMP));
    }
    
    @Test
    public void updateDomainObjectDepth0Fields_assigns_depth_0_fields_when_simple_id() throws DAOException {
        setDataClassSimpleId();
        domainClassSimpleId = new DomainClassSimpleId();
        
        dao.updateDomainObjectDepth0Fields(domainClassSimpleId, dataClassSimpleId);
        

        assertThat(domainClassSimpleId.getId(), equalTo(ID));
        assertThat(domainClassSimpleId.getDate().getTime(),equalTo(TIMESTAMP));
        assertThat(domainClassSimpleId.isEnabled(),equalTo(dataClassSimpleId.isEnabled()));
        assertThat(domainClassSimpleId.getName(),equalTo(NAME));
    }

    private void setDomainClassSimpleId() {
        domainClassSimpleId = new DomainClassSimpleId();
        domainClassSimpleId.setName(NAME);
        domainClassSimpleId.setEnabled(true);
        domainClassSimpleId.setId(ID);
        domainClassSimpleId.setDate(new java.util.Date(TIMESTAMP));
    }   
    
    @Test
    public void updateDataObjectDepth0Fields_assigns_depth_0_fields_when_simple_id() throws DAOException {
        setDomainClassSimpleId();
         dataClassSimpleId = new DataClassSimpleId();
        
        dao.updateDataObjectDepth0Fields(domainClassSimpleId, dataClassSimpleId);
        
        assertThat(dataClassSimpleId.getId(), equalTo(ID));
        assertThat(dataClassSimpleId.getDate().getTime(),equalTo(TIMESTAMP));
        assertThat(dataClassSimpleId.isEnabled(),equalTo(domainClassSimpleId.isEnabled()));
        assertThat(dataClassSimpleId.getName(),equalTo(NAME));        
    }    
    
    private void setDataClassEmbeddedId(EmbeddedId embeddedId, DataClassSimpleId dataClassSimpleId) {
         dataClassEmbeddedId = new DataClassEmbeddedId();
         dataClassEmbeddedId.setId(embeddedId);
         dataClassEmbeddedId.setRelatedObject(dataClassSimpleId);
         dataClassEmbeddedId.setName(NAME);
         dataClassEmbeddedId.setEnabled(false);
         
    }    

    private void setEmbeddedId() {
        embeddedId = new EmbeddedId();
        embeddedId.setInteger(ID);
        embeddedId.setString(NAME);
    }
    
   @Test
   public void updateDomainObjectDeeperFields_assigns_fields() throws DAOException {
       setEmbeddedId();
       setDataClassSimpleId();
       setDataClassEmbeddedId(embeddedId, dataClassSimpleId);
       domainClassCompositeId = new DomainClassCompositeId();
       dao = new GenericAbstractDAOEmbeddedIdsWrapper(mockedEntityManagerFactory);
       GenericAbstractDAOWrapper triggleAbstractDAOWrapper = new GenericAbstractDAOWrapper(mockedEntityManagerFactory);
       when(mockedGenericDAOFactory.getDAO(DataClassSimpleId.class)).thenReturn(triggleAbstractDAOWrapper);
       
       dao.updateDomainObjectDeeperFields(domainClassCompositeId, dataClassEmbeddedId, 0);
       
       assertThat(domainClassCompositeId.getRelatedObject(), notNullValue());
   }
   
    private void setCompositeId() {
        compositeId = new CompositeId();
        compositeId.setInteger(ID);
        compositeId.setString(NAME);
    }
    
    private void setDomainClassCompositeId(CompositeId embeddedId, DomainClassSimpleId domainClassSimpleId) {
         domainClassCompositeId = new DomainClassCompositeId();
         domainClassCompositeId.setId(embeddedId);
         domainClassCompositeId.setRelatedObject(domainClassSimpleId);
         domainClassCompositeId.setEnabled(false);
         domainClassCompositeId.setName(NAME);
    }  
    
   @Test
   public void updateDataObjectDeeperFields_assigns_fields() throws DAOException {
       setCompositeId();
       setDomainClassSimpleId();
       setDomainClassCompositeId(compositeId, domainClassSimpleId);
       dataClassEmbeddedId = new DataClassEmbeddedId();
       dao = new GenericAbstractDAOEmbeddedIdsWrapper(mockedEntityManagerFactory);
       GenericAbstractDAOWrapper triggleAbstractDAOWrapper = new GenericAbstractDAOWrapper(mockedEntityManagerFactory);
       when(mockedGenericDAOFactory.getDAO(DataClassSimpleId.class)).thenReturn(triggleAbstractDAOWrapper);
       
       dao.updateDataObjectDeeperFields(domainClassCompositeId, dataClassEmbeddedId, 0);
       
       assertThat(dataClassEmbeddedId.getRelatedObject(), notNullValue());
   }
    
   
   @Test
   public void updateDomainObjectDeeperFields_assigns_collections() throws DAOException {
       setEmbeddedId();
       setDataClassSimpleId();
       setDataClassEmbeddedId(embeddedId, dataClassSimpleId);
       dataClassSimpleId.getRelatedObjects().add(dataClassEmbeddedId);
       domainClassSimpleId = new DomainClassSimpleId();
       GenericAbstractDAOEmbeddedIdsWrapper triggleAbstractDAOWrapper = new GenericAbstractDAOEmbeddedIdsWrapper(mockedEntityManagerFactory);
       when(mockedGenericDAOFactory.getDAO(DataClassEmbeddedId.class)).thenReturn(triggleAbstractDAOWrapper);
       
       dao.updateDomainObjectDeeperFields(domainClassSimpleId, dataClassSimpleId, 0);
       
       assertThat(domainClassSimpleId.getRelatedObjects().isEmpty(), equalTo(false));
   }   
   
   @Test
   public void updateDataObjectDeeperFields_assigns_collections() throws DAOException {
       setCompositeId();
       setDomainClassSimpleId();
       setDomainClassCompositeId(compositeId, domainClassSimpleId);
       domainClassSimpleId.getRelatedObjects().add(domainClassCompositeId);
       dataClassSimpleId = new DataClassSimpleId();
       GenericAbstractDAOEmbeddedIdsWrapper triggleAbstractDAOWrapper = new GenericAbstractDAOEmbeddedIdsWrapper(mockedEntityManagerFactory);
       when(mockedGenericDAOFactory.getDAO(DomainClassCompositeId.class)).thenReturn(triggleAbstractDAOWrapper);
       
       dao.updateDataObjectDeeperFields(domainClassSimpleId, dataClassSimpleId, 0);
       
       assertThat(dataClassSimpleId.getRelatedObjects().isEmpty(), equalTo(false));
   }     
}

class GenericAbstractDAOWrapper extends GenericAbstractDAO<DomainClassSimpleId, DataClassSimpleId> {

    public GenericAbstractDAOWrapper(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory);
    }

    @Override
    protected Class<DataClassSimpleId> getDAOClass() {
        return DataClassSimpleId.class;
    }

    @Override
    protected DomainClassSimpleId getDomainObjectNewInstance() {
        return new DomainClassSimpleId();
    }

    @Override
    protected DataClassSimpleId getDataObjectNewInstance() {
        return new DataClassSimpleId();
    }

    @Override
    protected Class<DomainClassSimpleId> getDAODomainClass() {
        return DomainClassSimpleId.class;
    }


}

class GenericAbstractDAOEmbeddedIdsWrapper extends GenericAbstractDAO<DomainClassCompositeId, DataClassEmbeddedId> {

    public GenericAbstractDAOEmbeddedIdsWrapper(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory);
    }

    @Override
    protected Class<DomainClassCompositeId> getDAODomainClass() {
        return DomainClassCompositeId.class;
    }

    @Override
    protected Class<DataClassEmbeddedId> getDAOClass() {
        return DataClassEmbeddedId.class;
    }

    @Override
    protected DomainClassCompositeId getDomainObjectNewInstance() {
        return new DomainClassCompositeId();
    }

    @Override
    protected DataClassEmbeddedId getDataObjectNewInstance() {
        return new DataClassEmbeddedId();
    }

    @Override
    protected ICompositeId getCompositedId(IEmbeddable dataObject) throws DAOException {
        CompositeId compositeId = new CompositeId(); 
        compositeId.setInteger(((EmbeddedId)dataObject).getInteger());
        compositeId.setString(((EmbeddedId)dataObject).getString());
        return compositeId;
    }

    @Override
    protected IEmbeddable getEmmbeddedId(ICompositeId domainObject) throws DAOException {
        EmbeddedId embeddedId = new EmbeddedId();
        embeddedId.setInteger(((CompositeId)domainObject).getInteger());
        embeddedId.setString(((CompositeId)domainObject).getString());
        return embeddedId;
    }



}
