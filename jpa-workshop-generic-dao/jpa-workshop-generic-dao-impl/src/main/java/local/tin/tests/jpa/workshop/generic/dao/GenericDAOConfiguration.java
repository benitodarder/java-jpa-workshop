package local.tin.tests.jpa.workshop.generic.dao;

import java.util.HashMap;
import java.util.Map;
import local.tin.tests.jpa.workshop.dao.configuration.AbstractDAOConfiguration;
import org.apache.log4j.Logger;

/**
 *
 * @author benito.darder
 */
public class GenericDAOConfiguration extends AbstractDAOConfiguration {

    private static final Logger LOGGER = Logger.getLogger(GenericDAOConfiguration.class);
    private static Map<String, String> configurationMap;

    private GenericDAOConfiguration() {
    }

    public static synchronized GenericDAOConfiguration getInstance() {

        if (configurationMap == null) {
            configurationMap = new HashMap<>();
        }
        return DAOConfigurationConfigurationHolder.INSTANCE;
    }

    private static class DAOConfigurationConfigurationHolder {

        private static final GenericDAOConfiguration INSTANCE = new GenericDAOConfiguration();

        private DAOConfigurationConfigurationHolder() {
        }
    }

    @Override
    public Map<String, String> getConfigurationMap() {
        return configurationMap;
    }

    @Override
    public Logger getLogger() {
        return LOGGER;
    }

}
