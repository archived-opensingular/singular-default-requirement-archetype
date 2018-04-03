#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${modulePrefixName}module.spring;

import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.Oracle10gDialect;
import org.opensingular.app.commons.spring.persistence.database.SingularPersistenceConfiguration;
import java.util.List;

public class PersistenceConfiguration implements SingularPersistenceConfiguration {

    private final static String DDL_INSERT = "/db/ddl/create-${modulePrefixName}-actor.sql";
    private final static String DML_INSERT = "/db/dml/insert-${modulePrefixName}-module.sql";

    @Override
    public Class<? extends Dialect> getHibernateDialect() {
        return Oracle10gDialect.class;
    }

    @Override
    public void configureInitSQLScripts(List<String> scripts) {
        scripts.add(DDL_INSERT);
        scripts.add(DML_INSERT);
    }

    @Override
    public void configureHibernatePackagesToScan(List<String> packagesToScan) {
    packagesToScan.add(${package});
    }

}
