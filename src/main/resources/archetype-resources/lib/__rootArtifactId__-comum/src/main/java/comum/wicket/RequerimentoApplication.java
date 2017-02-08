#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.comum.wicket;

import org.opensingular.server.commons.wicket.SingularApplication;

public abstract class RequerimentoApplication extends SingularApplication {

    @Override
    protected String[] getPackagesToScan() {
        return new String[]{"${package}"};
    }

}