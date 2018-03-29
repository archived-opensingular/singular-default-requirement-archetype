#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${modulePrefixName}module.spring;

import java.util.List;
import javax.annotation.Nonnull;

import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.Oracle10gDialect;
import org.opensingular.server.commons.spring.ConfigureDatabaseResource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

public class ${moduleClassNamePrefix}DatabaseConfigure extends ConfigureDatabaseResource {

    @Value("classpath:db/dml/insert-${modulePrefixName}-module.sql")
    private Resource ${modulePrefixName}Module;

        private final static String DDL_INSERT = "/db/ddl/create-${modulePrefixName}-actor.sql";
        private final static String DML_INSERT = "/db/dml/insert-${modulePrefixName}-module.sql";

    @Override
    protected String getUrlConnection() {
        return "jdbc:h2:file:./singularserverdb;AUTO_SERVER=TRUE;mode=ORACLE;CACHE_SIZE=4096;EARLY_FILTER=1;LOCK_TIMEOUT=15000;";
    }

    @Nonnull
    @Override
    public Class<? extends Dialect> getHibernateDialect() {
        return Oracle10gDialect.class;
    }

    @Override
    public List<String> getImportFiles(String... directoryAndFile) {
        return super.getImportFiles(DDL_INSERT, DML_INSERT);
    }


}