#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${modulePrefixName}server.config;

import ${package}.${modulePrefixName}server.spring.PersistenceConfiguration;
import org.opensingular.server.commons.spring.SingularDefaultPersistenceConfiguration;

public class ServerInitializer extends org.opensingular.server.core.config.ServerInitializer {


    @Override
    protected Class<? extends SingularDefaultPersistenceConfiguration> persistenceConfiguration() {
        return PersistenceConfiguration.class;
    }

    @Override
    protected String[] springPackagesToScan() {
        return new String[]{"${package}"};
    }
}
