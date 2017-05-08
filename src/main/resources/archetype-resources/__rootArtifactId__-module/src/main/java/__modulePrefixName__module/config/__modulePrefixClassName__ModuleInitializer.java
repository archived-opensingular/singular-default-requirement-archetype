#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${modulePrefixName}module.config;

import ${package}.${modulePrefixName}module.spring.PersistenceConfiguration;
import org.opensingular.server.commons.spring.SingularDefaultPersistenceConfiguration;
import org.opensingular.server.module.config.ModuleInitializer;


public class ${modulePrefixClassName}ModuleInitializer extends ModuleInitializer {


    @Override
    protected String processGroupCod() {
        return "${moduleConstant}";
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
