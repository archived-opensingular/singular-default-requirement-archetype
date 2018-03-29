#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${modulePrefixName}module.spring;

import org.opensingular.requirement.commons.spring.ConfigureDatabaseResource;
import org.opensingular.requirement.commons.spring.SingularDefaultPersistenceConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement(
        proxyTargetClass = true
)
public class PersistenceConfiguration extends SingularDefaultPersistenceConfiguration {

    @Override
    protected ConfigureDatabaseResource getConfigureDatabaseResource() {
        return new ${moduleClassNamePrefix}DatabaseConfigure();
    }
}