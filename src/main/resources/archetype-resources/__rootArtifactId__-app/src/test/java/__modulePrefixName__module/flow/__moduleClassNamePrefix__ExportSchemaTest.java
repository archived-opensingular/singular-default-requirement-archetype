#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${modulePrefixName}module.flow;

import ${package}.${modulePrefixName}module.spring.${moduleClassNamePrefix}DatabaseConfigure;
import org.opensingular.server.commons.test.SingularSchemaExportTest;

public class ${moduleClassNamePrefix}ExportSchemaTest extends SingularSchemaExportTest {

    @Override
    public void generateScriptByDialect() {
    ${moduleClassNamePrefix}DatabaseConfigure config = new ${moduleClassNamePrefix}DatabaseConfigure();
        generateScript(null, null, config.getHibernateDialect(), config.getScriptsPath());
    }
}



