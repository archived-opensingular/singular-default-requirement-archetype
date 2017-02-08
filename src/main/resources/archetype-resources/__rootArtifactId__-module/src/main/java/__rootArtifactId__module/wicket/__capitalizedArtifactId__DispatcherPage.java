#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${rootArtifactId}module.wicket;

import org.apache.wicket.request.Request;
import ${package}.${rootArtifactId}module.flow.${capitalizedArtifactId}Flow;
import org.opensingular.server.commons.form.FormActions;
import org.opensingular.server.commons.wicket.view.form.FormPageConfig;
import org.opensingular.server.commons.wicket.view.util.DispatcherPageUtil;
import org.opensingular.server.module.wicket.view.util.dispatcher.DispatcherPage;
import org.wicketstuff.annotation.mount.MountPath;

@SuppressWarnings("serial")
@MountPath(DispatcherPageUtil.DISPATCHER_PAGE_PATH)
public class ${capitalizedArtifactId}DispatcherPage extends DispatcherPage {

    @Override
    protected FormPageConfig buildConfig(Request r, String petitionId, FormActions formAction, String formType, Long formVersionKey, String parentPetitionId, boolean diff) {
        return FormPageConfig.newConfig(petitionId, formType, formAction, formVersionKey, parentPetitionId, ${capitalizedArtifactId}Flow.class);
    }

}