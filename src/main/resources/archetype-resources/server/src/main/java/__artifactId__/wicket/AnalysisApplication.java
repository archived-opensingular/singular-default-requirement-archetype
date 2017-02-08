#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId}.wicket;

import org.apache.wicket.Page;
import ${package}.comum.wicket.RequerimentoApplication;
import org.opensingular.server.core.wicket.box.BoxPage;


public class AnalysisApplication extends RequerimentoApplication {

    @Override
    public Class<? extends Page> getHomePage() {
        return BoxPage.class;
    }
}
