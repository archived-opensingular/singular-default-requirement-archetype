#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${modulePrefixName}module;

import ${package}.${modulePrefixName}module.flow.${moduleClassNamePrefix}Flow;
import ${package}.${modulePrefixName}module.form.${moduleClassNamePrefix}Form;
import org.opensingular.server.commons.requirement.SingularRequirement;
import org.opensingular.server.module.RequirementConfiguration;
import org.opensingular.server.module.SingularModule;
import org.opensingular.server.module.WorkspaceConfiguration;
import org.opensingular.server.module.requirement.FormFlowSingularRequirement;
import org.opensingular.server.module.workspace.DefaultDonebox;
import org.opensingular.server.module.workspace.DefaultInbox;
import org.opensingular.server.p.module.workspace.DefaultDraftbox;
import org.opensingular.server.p.module.workspace.DefaultOngoingbox;

public class ${moduleClassNamePrefix}Module implements SingularModule {

    public static final String              ${moduleStringIDName} = "${moduleStringIDName}";
    private             SingularRequirement ${modulePrefixName} = new FormFlowSingularRequirement("${moduleClassNamePrefix}", ${moduleClassNamePrefix}Form.class, ${moduleClassNamePrefix}Flow.class);

    @Override
    public String category() {
        return ${moduleStringIDName};
    }

    @Override
    public String name() {
        return "Módulo ${moduleClassNamePrefix}";
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
