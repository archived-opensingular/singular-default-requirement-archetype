#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${modulePrefixName}module.wicket;

import org.apache.wicket.Page;
import ${package}.comum.wicket.RequerimentoApplication;

public class ${modulePrefixClassName}Application extends RequerimentoApplication {

    @Override
    public Class<? extends Page> getHomePage() {
        return ${modulePrefixClassName}DispatcherPage.class;
    }

}