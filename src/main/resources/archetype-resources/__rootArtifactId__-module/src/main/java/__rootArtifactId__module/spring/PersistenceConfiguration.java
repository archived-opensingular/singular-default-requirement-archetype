#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${rootArtifactId}module.spring;

import org.opensingular.server.commons.spring.SingularDefaultPersistenceConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement(
        proxyTargetClass = true
)
public class PersistenceConfiguration extends SingularDefaultPersistenceConfiguration {

    @Value("classpath:db/dml/insert-${rootArtifactId}-module.sql")
    private Resource ${rootArtifactId}Module;

    @Override
    protected ResourceDatabasePopulator databasePopulator() {
        ResourceDatabasePopulator populator = super.databasePopulator();
        populator.addScript(${rootArtifactId}Module);
        return populator;
    }

}