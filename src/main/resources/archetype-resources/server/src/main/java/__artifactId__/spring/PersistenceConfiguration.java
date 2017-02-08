#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId}.spring;

import org.opensingular.server.commons.spring.SingularDefaultPersistenceConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableTransactionManagement(
        proxyTargetClass = true
)
public class PersistenceConfiguration extends SingularDefaultPersistenceConfiguration {
    @Override
    protected boolean isDatabaseInitializerEnabled() {
        return false;
    }
}
