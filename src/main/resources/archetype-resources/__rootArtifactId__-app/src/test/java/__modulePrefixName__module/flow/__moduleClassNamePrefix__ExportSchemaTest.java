#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${modulePrefixName}module.flow;

import org.junit.Ignore;
import org.junit.Test;
import org.opensingular.flow.core.ProcessDefinition;
import org.opensingular.server.commons.flow.FlowRenderTest;

public class ${moduleClassNamePrefix}ExportSchemaTest extends SingularSchemaExportTest {

        @Override
        public void generateScriptByDialect() {
        ${moduleClassNamePrefix}DatabaseConfigure config = new ${moduleClassNamePrefix}DatabaseConfigure();
            generateScript(null ,config.getHibernateDialect(), config.getScriptsPath());
        }
}



