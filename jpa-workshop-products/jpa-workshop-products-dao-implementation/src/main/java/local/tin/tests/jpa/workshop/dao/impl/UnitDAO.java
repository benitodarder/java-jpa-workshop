package local.tin.tests.jpa.workshop.dao.impl;

import javax.persistence.EntityManagerFactory;
import local.tin.tests.jpa.workshop.model.data.product.Component;
import local.tin.tests.jpa.workshop.model.data.product.Unit;
import local.tin.tests.jpa.workshop.model.domain.exceptions.DAOException;


/**
 *
 * @author benito.darder
 */
public class UnitDAO extends AbstractDAO<local.tin.tests.jpa.workshop.model.domain.product.Unit, Unit>{

    public UnitDAO(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory);
    }

    @Override
    protected Class<Unit> getDAOClass() {
        return Unit.class;
    }

    @Override
    protected local.tin.tests.jpa.workshop.model.domain.product.Unit getDomainObjectNewInstance() {
        return new local.tin.tests.jpa.workshop.model.domain.product.Unit();
    }

    @Override
    protected Unit getDataObjectNewInstance() {
        return new Unit();
    }

    @Override
    protected local.tin.tests.jpa.workshop.model.domain.product.Unit updateDomainObjectDepth0Fields(local.tin.tests.jpa.workshop.model.domain.product.Unit domainObject, Unit dataObject) throws DAOException {
                domainObject.setName(dataObject.getName());
                domainObject.setAbbreviation(dataObject.getAbbreviation());
                return domainObject;
    }

    @Override
    protected local.tin.tests.jpa.workshop.model.domain.product.Unit updateDomainObjectDeeperFields(local.tin.tests.jpa.workshop.model.domain.product.Unit domainObject, Unit dataObject, int depth) throws DAOException {
        ComponentDAO componentDAO = getComponentDAO();
        for (Component current : dataObject.getComponents()) {
            domainObject.getComponents().add(componentDAO.getDomainObject(current, depth));
        }
        return domainObject;
    }

    @Override
    protected Unit updateDataObjectDepth0Fields(local.tin.tests.jpa.workshop.model.domain.product.Unit domainObject, Unit dataObject) throws DAOException {
        dataObject.setName(domainObject.getName());
        dataObject.setAbbreviation(domainObject.getAbbreviation());
        return dataObject;
    }

    @Override
    protected Unit updateDataObjectDeeperFields(local.tin.tests.jpa.workshop.model.domain.product.Unit domainObject, Unit dataObject, int depth) throws DAOException {
        ComponentDAO componentDAO = getComponentDAO();
        for (local.tin.tests.jpa.workshop.model.domain.product.Component current : domainObject.getComponents()) {
            dataObject.getComponents().add(componentDAO.getDataObject(current, depth));
        }        
        return dataObject;
    }
    
    private ComponentDAO getComponentDAO() throws DAOException {
        return (ComponentDAO) ProductDAOFactory.getInstance().getDAO(Component.class);
    }
}
