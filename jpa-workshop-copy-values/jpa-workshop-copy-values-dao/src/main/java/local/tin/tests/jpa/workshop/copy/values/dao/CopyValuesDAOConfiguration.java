package local.tin.tests.jpa.workshop.copy.values.dao;

import java.util.HashMap;
import java.util.Map;
import local.tin.tests.jpa.workshop.dao.configuration.AbstractDAOConfiguration;
import org.apache.log4j.Logger;

/**
 *
 * @author benito.darder
 */
public class CopyValuesDAOConfiguration extends AbstractDAOConfiguration {

    private static final Logger LOGGER = Logger.getLogger(CopyValuesDAOConfiguration.class);
    private static Map<String, String> configurationMap;

    private CopyValuesDAOConfiguration() {
    }

    public static synchronized CopyValuesDAOConfiguration getInstance() {

        if (configurationMap == null) {
            configurationMap = new HashMap<>();
        }
        return DAOConfigurationConfigurationHolder.INSTANCE;
    }

    private static class DAOConfigurationConfigurationHolder {

        private static final CopyValuesDAOConfiguration INSTANCE = new CopyValuesDAOConfiguration();

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
