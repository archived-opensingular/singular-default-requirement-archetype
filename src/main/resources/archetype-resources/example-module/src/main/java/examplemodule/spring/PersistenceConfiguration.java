#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.examplemodule.spring;

import org.opensingular.server.commons.spring.SingularDefaultPersistenceConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement(
        proxyTargetClass = true
)
public class PersistenceConfiguration extends SingularDefaultPersistenceConfiguration {

    @Value("classpath:db/dml/insert-${artifactId}.sql")
    private Resource exampleModule;

    @Override
    protected ResourceDatabasePopulator databasePopulator() {
        ResourceDatabasePopulator populator = super.databasePopulator();
        populator.addScript(exampleModule);
        return populator;
    }

}