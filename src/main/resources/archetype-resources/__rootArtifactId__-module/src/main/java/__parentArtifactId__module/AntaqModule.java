#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}module;

import ${package}.${parentArtifactId}module.flow.AntaqFlow;
import ${package}.${parentArtifactId}module.form.AntaqForm;
import org.opensingular.server.commons.requirement.SingularRequirement;
import org.opensingular.server.module.RequirementConfiguration;
import org.opensingular.server.module.SingularModule;
import org.opensingular.server.module.WorkspaceConfiguration;
import org.opensingular.server.module.requirement.FormFlowSingularRequirement;
import org.opensingular.server.module.workspace.DefaultDonebox;
import org.opensingular.server.module.workspace.DefaultInbox;
import org.opensingular.server.p.module.workspace.DefaultDraftbox;
import org.opensingular.server.p.module.workspace.DefaultOngoingbox;

public class AntaqModule implements SingularModule {

    public static final String              ANTAQ = "ANTAQ";
    private             SingularRequirement ${parentArtifactId} = new FormFlowSingularRequirement("Antaq", AntaqForm.class, AntaqFlow.class);

    @Override
    public String category() {
        return ANTAQ;
    }

    @Override
    public String name() {
        return "Módulo Antaq";
    }

    @Override
    public void requirements(RequirementConfiguration config) {
        config
                .addRequirement(${parentArtifactId});
    }

    @Override
    public void workspace(WorkspaceConfiguration config) {
        config
                .addBox(new DefaultDraftbox()).newFor(${parentArtifactId})
                .addBox(new DefaultInbox())
                .addBox(new DefaultOngoingbox())
                .addBox(new DefaultDonebox());
    }
}
