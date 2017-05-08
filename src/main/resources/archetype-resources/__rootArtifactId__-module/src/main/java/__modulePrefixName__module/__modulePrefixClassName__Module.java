#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${modulePrefixName}module;

import ${package}.${modulePrefixName}module.flow.${modulePrefixClassName}Flow;
import ${package}.${modulePrefixName}module.form.${modulePrefixClassName}Form;
import org.opensingular.server.commons.requirement.SingularRequirement;
import org.opensingular.server.module.RequirementConfiguration;
import org.opensingular.server.module.SingularModule;
import org.opensingular.server.module.WorkspaceConfiguration;
import org.opensingular.server.module.requirement.FormFlowSingularRequirement;
import org.opensingular.server.module.workspace.DefaultDonebox;
import org.opensingular.server.module.workspace.DefaultInbox;
import org.opensingular.server.p.module.workspace.DefaultDraftbox;
import org.opensingular.server.p.module.workspace.DefaultOngoingbox;

public class ${modulePrefixClassName}Module implements SingularModule {

    public static final String              ${moduleConstant} = "${moduleConstant}";
    private             SingularRequirement ${modulePrefixName} = new FormFlowSingularRequirement("${modulePrefixClassName}", ${modulePrefixClassName}Form.class, ${modulePrefixClassName}Flow.class);

    @Override
    public String category() {
        return ANTAQ;
    }

    @Override
    public String name() {
        return "Módulo ${modulePrefixClassName}";
    }

    @Override
    public void requirements(RequirementConfiguration config) {
        config
                .addRequirement(${modulePrefixName});
    }

    @Override
    public void workspace(WorkspaceConfiguration config) {
        config
                .addBox(new DefaultDraftbox()).newFor(${modulePrefixName})
                .addBox(new DefaultInbox())
                .addBox(new DefaultOngoingbox())
                .addBox(new DefaultDonebox());
    }
}
