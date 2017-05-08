#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}module.config;

import ${package}.${parentArtifactId}module.spring.PersistenceConfiguration;
import org.opensingular.server.commons.spring.SingularDefaultPersistenceConfiguration;
import org.opensingular.server.module.config.ModuleInitializer;


public class AntaqModuleInitializer extends ModuleInitializer {


    @Override
    protected String processGroupCod() {
        return "ANTAQMODULE";
    }

    @Override
    protected String[] springPackagesToScan() {
        return new String[]{"${package}"};
    }

    @Override
    protected Class<? extends SingularDefaultPersistenceConfiguration> persistenceConfiguration() {
        return PersistenceConfiguration.class;
    }
}
