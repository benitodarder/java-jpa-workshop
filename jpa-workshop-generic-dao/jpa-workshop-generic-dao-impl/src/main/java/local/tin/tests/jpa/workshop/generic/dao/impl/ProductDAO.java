package local.tin.tests.jpa.workshop.generic.dao.impl;

import javax.persistence.EntityManagerFactory;

/**
 *
 * @author benitodarder
 */
public class ProductDAO extends GenericAbstractDAO<local.tin.tests.jpa.workshop.model.domain.product.Product, local.tin.tests.jpa.workshop.model.data.product.Product>{

    public ProductDAO(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory);
    }

    @Override
    protected Class<local.tin.tests.jpa.workshop.model.domain.product.Product> getDAODomainClass() {
        return local.tin.tests.jpa.workshop.model.domain.product.Product.class;
    }

    @Override
    protected Class<local.tin.tests.jpa.workshop.model.data.product.Product> getDAOClass() {
        return local.tin.tests.jpa.workshop.model.data.product.Product.class;
    }
    
}
