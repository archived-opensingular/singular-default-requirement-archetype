#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.examplemodule.wicket;

import org.apache.wicket.Page;
import ${package}.comum.wicket.RequerimentoApplication;

public class ExampleApplication extends RequerimentoApplication {

    @Override
    public Class<? extends Page> getHomePage() {
        return ExampleDispatcherPage.class;
    }

}