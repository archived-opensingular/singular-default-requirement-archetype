#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${modulePrefixName}module;

import ${package}.${modulePrefixName}module.flow.${moduleClassNamePrefix}Flow;
import ${package}.${modulePrefixName}module.form.${moduleClassNamePrefix}Form;
import ${package}.${modulePrefixName}module.box.${moduleClassNamePrefix}CaixaPendencia;

import org.opensingular.requirement.commons.SingularRequirement;
import org.opensingular.requirement.module.FormFlowSingularRequirement;
import org.opensingular.requirement.module.RequirementConfiguration;
import org.opensingular.requirement.module.SingularModule;
import org.opensingular.requirement.module.WorkspaceConfiguration;
import org.opensingular.requirement.module.workspace.DefaultDonebox;
import org.opensingular.requirement.module.workspace.DefaultDraftbox;
import org.opensingular.requirement.module.workspace.DefaultInbox;
import org.opensingular.requirement.module.workspace.DefaultOngoingbox;

public class ${moduleClassNamePrefix}Module implements SingularModule {

    public static final String              ${moduleStringIDName} = "${moduleStringIDName}";
    private             SingularRequirement ${modulePrefixName} = new FormFlowSingularRequirement("${moduleClassNamePrefix}", ${moduleClassNamePrefix}Form.class, ${moduleClassNamePrefix}Flow.class);

    @Override
    public String abbreviation() {
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
                .addBox(new ${moduleClassNamePrefix}CaixaPendencia())
                .addBox(new DefaultInbox())
                .addBox(new DefaultOngoingbox())
                .addBox(new DefaultDonebox());
    }
}
