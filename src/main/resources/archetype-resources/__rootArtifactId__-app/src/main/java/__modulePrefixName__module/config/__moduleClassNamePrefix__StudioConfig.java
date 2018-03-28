#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${modulePrefixName}module.config;

import org.opensingular.lib.wicket.util.resource.DefaultIcons;
import org.opensingular.studio.core.config.StudioConfig;
import org.opensingular.studio.core.menu.StudioMenu;


public class ${moduleClassNamePrefix}StudioConfig implements StudioConfig {

    @Override
    public StudioMenu getAppMenu() {
        return StudioMenu.Builder.newPortalMenu()
            .addHTTPEndpoint(DefaultIcons.GLOBE, "Requerimento", "/requirement")
            .addHTTPEndpoint(DefaultIcons.COMMENT, "Análise", "/worklist")
            .getStudioMenu();
    }

}
