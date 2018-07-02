#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${modulePrefixName}module.flow;

import ${package}.${modulePrefixName}module.flow.${moduleClassNamePrefix}Flow;
import org.junit.Test;
import org.opensingular.requirement.commons.test.flow.AbstractFlowRenderTest;

public class ${moduleClassNamePrefix}FlowRenderTest extends AbstractFlowRenderTest {

    public ${moduleClassNamePrefix}FlowRenderTest() {
        setOpenGeneratedFiles(false);
    }

    @Test
    public void render() {
        super.renderImage(new ${moduleClassNamePrefix}Flow());
    }
}
