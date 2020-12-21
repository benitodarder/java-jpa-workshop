package local.tin.tests.jpa.workshop.generic.dao.impl;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import javax.persistence.EntityManagerFactory;
import local.tin.tests.jpa.workshop.dao.impl.AbstractDAO;
import local.tin.tests.jpa.workshop.dao.utils.CommonDAOUtils;
import local.tin.tests.jpa.workshop.model.domain.exceptions.DAOException;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;

/**
 *
 * @author developer01
 * @param <C0>
 * @param <C1>
 */
public abstract class GenericAbstractDAO<C0 extends local.tin.tests.jpa.workshop.model.domain.interfaces.IIdentifiable, C1 extends local.tin.tests.jpa.workshop.model.data.interfaces.IIdentifiable> extends AbstractDAO<C0, C1> {

    private static final Logger LOGGER = Logger.getLogger(GenericAbstractDAO.class);

    protected abstract Class<C0> getDAODomainClass();

    public GenericAbstractDAO(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory);
    }

    private Map<String, Field> getAllFields(Map<String, Field> fields, Class<?> type) {
        Arrays.asList(type.getDeclaredFields()).forEach((currentField) -> {
            fields.put(currentField.getName(), currentField);
        });

        if (type.getSuperclass() != null) {
            getAllFields(fields, type.getSuperclass());
        }

        return fields;
    }

    @Override
    protected C0 updateDomainObjectDepth0Fields(C0 domainObject, C1 dataObject) throws DAOException {
        Map<String, Field> dataFields = getAllFields(new HashMap<>(), getDAOClass());
        Map<String, Field> domainFields = getAllFields(new HashMap<>(), getDAODomainClass());
        C1 unproxiedEntity = (C1) Hibernate.unproxy(dataObject);
        for (Map.Entry<String, Field> currentEntry : dataFields.entrySet()) {
            try {
                if (isDepth0DataAttribute(currentEntry.getValue().getType())) {
                    currentEntry.getValue().setAccessible(true);
                    Field currentField = domainFields.get(currentEntry.getKey());
                    currentField.setAccessible(true);
                    currentField.set(domainObject, currentEntry.getValue().get(unproxiedEntity));
                }
            } catch (IllegalArgumentException | IllegalAccessException | SecurityException ex) {
                throw new DAOException(ex);
            }
        }
        return domainObject;
    }

    private boolean isDepth0DataAttribute(Class klass) {
        return !local.tin.tests.jpa.workshop.model.data.interfaces.IIdentifiable.class.isAssignableFrom(klass)
                && !Collection.class.isAssignableFrom(klass)
                && !local.tin.tests.jpa.workshop.model.data.interfaces.IEmbeddable.class.isAssignableFrom(klass);
    }

    @Override
    protected C0 updateDomainObjectDeeperFields(C0 domainObject, C1 dataObject, int depth) throws DAOException {
        Map<String, Field> dataFields = getAllFields(new HashMap<>(), getDAOClass());
        Map<String, Field> domainFields = getAllFields(new HashMap<>(), getDAODomainClass());
        C1 unproxiedEntity = (C1) Hibernate.unproxy(dataObject);
        for (Map.Entry<String, Field> currentEntry : dataFields.entrySet()) {
            try {
                if (isDeeperDataField(currentEntry)) {
                    currentEntry.getValue().setAccessible(true);
                    Field currentField = domainFields.get(currentEntry.getKey());
                    currentField.setAccessible(true);
                    if (Collection.class.isAssignableFrom(currentEntry.getValue().getType())) {
                        if (((Collection) currentEntry.getValue().get(unproxiedEntity)).stream().findFirst() != Optional.empty()) {
                            GenericAbstractDAO triggleDAO = (GenericAbstractDAO) GenericDAOFactory.getInstance().getDAO(((Collection) currentEntry.getValue().get(unproxiedEntity)).stream().findFirst().get().getClass());
                            Collection collection = new HashSet<>();
                            for (Object current : (Collection) currentEntry.getValue().get(dataObject)) {
                                collection.add(triggleDAO.getDomainObject((local.tin.tests.jpa.workshop.model.data.interfaces.IIdentifiable) current, depth));
                            }
                            currentField.set(domainObject, collection);
                        }
                    } else {
                        if (currentEntry.getValue().get(dataObject) != null) {
                            GenericAbstractDAO triggleDAO = (GenericAbstractDAO) GenericDAOFactory.getInstance().getDAO(currentEntry.getValue().getType());
                            currentField.set(domainObject, triggleDAO.getDomainObject((local.tin.tests.jpa.workshop.model.data.interfaces.IIdentifiable) currentEntry.getValue().get(dataObject), depth));
                        } else {
                            LOGGER.warn("Null value at: " + currentEntry.getValue().getDeclaringClass() + ", with id: " + dataObject.getId() + ", field: " + currentEntry.getValue().getName());
                        }
                    }
                }
            } catch (IllegalArgumentException | IllegalAccessException | SecurityException ex) {
                throw new DAOException(ex);
            }
        }
        return domainObject;
    }

    private boolean isDeeperDataField(Map.Entry<String, Field> currentEntry) {
        return local.tin.tests.jpa.workshop.model.data.interfaces.IIdentifiable.class.isAssignableFrom(currentEntry.getValue().getType())
                || Collection.class.isAssignableFrom(currentEntry.getValue().getType());
    }

    @Override
    protected C1 updateDataObjectDepth0Fields(C0 domainObject, C1 dataObject) throws DAOException {
        Map<String, Field> dataFields = getAllFields(new HashMap<>(), getDAOClass());
        Map<String, Field> domainFields = getAllFields(new HashMap<>(), getDAODomainClass());
        for (Map.Entry<String, Field> currentEntry : domainFields.entrySet()) {
            try {
                if (isDepth0DomainAttribute(currentEntry.getValue().getType())) {
                    currentEntry.getValue().setAccessible(true);
                    Field currentField = dataFields.get(currentEntry.getKey());
                    currentField.setAccessible(true);
                    if (Date.class.isAssignableFrom(currentEntry.getValue().getType())) {
                        if (currentField.getType().equals(java.sql.Timestamp.class)) {
                            currentField.set(dataObject, CommonDAOUtils.getInstance().getTimeStampFromDate((Date) currentEntry.getValue().get(domainObject)));
                        } else if (currentField.getType().equals(java.sql.Date.class)) {
                            currentField.set(dataObject, CommonDAOUtils.getInstance().getSQLDateFromDate((Date) currentEntry.getValue().get(domainObject)));
                        }
                    } else {
                        currentField.set(dataObject, currentEntry.getValue().get(domainObject));
                    }
                }
            } catch (IllegalArgumentException | IllegalAccessException | SecurityException ex) {
                throw new DAOException(ex);
            }
        }
        return dataObject;
    }

    @Override
    protected C1 updateDataObjectDeeperFields(C0 domainObject, C1 dataObject, int depth) throws DAOException {
        Map<String, Field> dataFields = getAllFields(new HashMap<>(), getDAOClass());
        Map<String, Field> domainFields = getAllFields(new HashMap<>(), getDAODomainClass());
        for (Map.Entry<String, Field> currentEntry : domainFields.entrySet()) {
            try {
                if (isDeeperDomainField(currentEntry.getValue().getType())) {
                    currentEntry.getValue().setAccessible(true);
                    Field currentField = dataFields.get(currentEntry.getKey());
                    currentField.setAccessible(true);
                    if (Collection.class.isAssignableFrom(currentEntry.getValue().getType())) {
                        if (((Collection) currentEntry.getValue().get(domainObject)) != null && ((Collection) currentEntry.getValue().get(domainObject)).stream().findFirst() != Optional.empty()) {
                            GenericAbstractDAO triggleDAO = (GenericAbstractDAO) GenericDAOFactory.getInstance().getDAO(((Collection) currentEntry.getValue().get(domainObject)).stream().findFirst().get().getClass());
                            Collection collection = new HashSet<>();
                            for (Object current : (Collection) currentEntry.getValue().get(domainObject)) {
                                collection.add(triggleDAO.getDataObject((local.tin.tests.jpa.workshop.model.domain.interfaces.IIdentifiable) current, depth));
                            }
                            currentField.set(dataObject, collection);
                        }
                    } else {
                        GenericAbstractDAO triggleDAO = (GenericAbstractDAO) GenericDAOFactory.getInstance().getDAO(currentField.getType());
                        currentField.set(dataObject, triggleDAO.getDataObject((local.tin.tests.jpa.workshop.model.domain.interfaces.IIdentifiable) currentEntry.getValue().get(domainObject), depth));
                    }
                }
            } catch (IllegalArgumentException | IllegalAccessException | SecurityException ex) {
                throw new DAOException(ex);
            }
        }
        return dataObject;
    }

    private boolean isDepth0DomainAttribute(Class klass) {
        return !local.tin.tests.jpa.workshop.model.domain.interfaces.IIdentifiable.class.isAssignableFrom(klass)
                && !Collection.class.isAssignableFrom(klass)
                && !local.tin.tests.jpa.workshop.model.domain.interfaces.ICompositeId.class.isAssignableFrom(klass);
    }

    private boolean isDeeperDomainField(Class klass) {
        return local.tin.tests.jpa.workshop.model.domain.interfaces.IIdentifiable.class.isAssignableFrom(klass)
                || Collection.class.isAssignableFrom(klass);
    }

    @Override
    protected C1 getDataObjectNewInstance() throws DAOException {
        try {
            return getDAOClass().newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            throw new DAOException(ex);
        }
    }

    @Override
    protected C0 getDomainObjectNewInstance() throws DAOException {
        try {
            return getDAODomainClass().newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            throw new DAOException(ex);
        }
    }

}
