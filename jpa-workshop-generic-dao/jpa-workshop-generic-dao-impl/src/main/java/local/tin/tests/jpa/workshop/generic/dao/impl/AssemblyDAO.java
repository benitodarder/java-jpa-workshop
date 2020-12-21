package local.tin.tests.jpa.workshop.generic.dao.impl;

import javax.persistence.EntityManagerFactory;
import local.tin.tests.jpa.workshop.model.data.embeddables.AssemblyId;
import local.tin.tests.jpa.workshop.model.data.interfaces.IEmbeddable;
import local.tin.tests.jpa.workshop.model.domain.exceptions.DAOException;
import local.tin.tests.jpa.workshop.model.domain.interfaces.ICompositeId;
import local.tin.tests.jpa.workshop.model.domain.product.Assembly;

/**
 *
 * @author benitodarder
 */
public class AssemblyDAO extends GenericAbstractDAO<local.tin.tests.jpa.workshop.model.domain.product.Assembly, local.tin.tests.jpa.workshop.model.data.product.Assembly>{

    public AssemblyDAO(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory);
    }

    @Override
    protected Class<Assembly> getDAODomainClass() {
        return local.tin.tests.jpa.workshop.model.domain.product.Assembly.class;
    }

    @Override
    protected Class<local.tin.tests.jpa.workshop.model.data.product.Assembly> getDAOClass() {
        return local.tin.tests.jpa.workshop.model.data.product.Assembly.class;
    }
    
    @Override
    protected AssemblyId getEmmbeddedId(ICompositeId domainObject) throws DAOException {
        AssemblyId embeddable = new AssemblyId();
        embeddable.setComponentId(((local.tin.tests.jpa.workshop.model.domain.compositeIds.AssemblyId) domainObject).getComponentId());
        embeddable.setProductId(((local.tin.tests.jpa.workshop.model.domain.compositeIds.AssemblyId) domainObject).getProductId());
        return embeddable;
    }

    @Override
    protected local.tin.tests.jpa.workshop.model.domain.compositeIds.AssemblyId getCompositedId(IEmbeddable dataObject) throws DAOException {
        local.tin.tests.jpa.workshop.model.domain.compositeIds.AssemblyId compositeId = new local.tin.tests.jpa.workshop.model.domain.compositeIds.AssemblyId();
        compositeId.setComponentId(((AssemblyId) dataObject).getComponentId());
        compositeId.setProductId(((AssemblyId) dataObject).getProductId());
        return compositeId;
    }    
}
