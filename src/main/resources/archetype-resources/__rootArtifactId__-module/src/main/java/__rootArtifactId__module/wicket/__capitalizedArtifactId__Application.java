#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${rootArtifactId}module.wicket;

import org.apache.wicket.Page;
import ${package}.comum.wicket.RequerimentoApplication;

public class ${capitalizedArtifactId}Application extends RequerimentoApplication {

    @Override
    public Class<? extends Page> getHomePage() {
        return ${capitalizedArtifactId}DispatcherPage.class;
    }

}