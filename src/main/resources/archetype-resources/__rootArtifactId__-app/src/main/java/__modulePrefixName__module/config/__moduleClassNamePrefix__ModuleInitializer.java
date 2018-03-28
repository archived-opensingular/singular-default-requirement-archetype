#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${modulePrefixName}module.config;

import ${package}.${modulePrefixName}module.spring.PersistenceConfiguration;
import org.opensingular.server.commons.spring.SingularDefaultPersistenceConfiguration;
import org.opensingular.server.studio.init.ServerStudioAppInitializer;


public class ${moduleClassNamePrefix}ModuleInitializer implements ServerStudioAppInitializer {

    @Override
    public String moduleCod() {
        return "${moduleStringIDName}";
    }

    @Override
    public String[] springPackagesToScan() {
        return new String[]{"${package}"};
    }

    @Override
    public Class<? extends SingularDefaultPersistenceConfiguration> persistenceConfiguration() {
        return PersistenceConfiguration.class;
    }

}
