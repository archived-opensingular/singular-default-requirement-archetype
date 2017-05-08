#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${modulePrefixName}module.flow;

import org.junit.Ignore;
import org.junit.Test;
import org.opensingular.flow.core.ProcessDefinition;
import org.opensingular.server.commons.flow.FlowRenderTest;

public class ${modulePrefixClassName}FlowRenderTest extends FlowRenderTest {

    @Override
    protected ProcessDefinition<?> getInstanceToRender() {
        return new ${modulePrefixClassName}Flow();
    }

    @Ignore
    @Test
    @Override
    public void render() {
        super.render();
    }
}
