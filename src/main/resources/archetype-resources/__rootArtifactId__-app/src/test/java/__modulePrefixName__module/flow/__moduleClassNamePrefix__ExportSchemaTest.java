#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${modulePrefixName}module.flow;

import org.opensingular.server.commons.test.SingularSchemaExportTest;

public class ${moduleClassNamePrefix}ExportSchemaTest extends SingularSchemaExportTest {

    @Override
    public void generateScriptByDialect() {
        generateScript();
    }

}
