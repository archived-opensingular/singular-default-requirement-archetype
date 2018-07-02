#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${modulePrefixName}module.flow;

import ${package}.${modulePrefixName}module.${moduleClassNamePrefix}Module;
import org.opensingular.flow.core.DefinitionInfo;
import org.opensingular.flow.core.ITaskDefinition;
import org.opensingular.flow.core.FlowInstance;
import org.opensingular.flow.core.defaults.PermissiveTaskAccessStrategy;

import org.opensingular.requirement.commons.flow.builder.RequirementFlowBuilder;
import org.opensingular.requirement.commons.flow.builder.RequirementFlowDefinition;
import org.opensingular.requirement.commons.wicket.view.form.FormPage;


import javax.annotation.Nonnull;

import static ${package}.${modulePrefixName}module.flow.${moduleClassNamePrefix}Flow.${moduleClassNamePrefix}Tasks.ANALISAR;
import static ${package}.${modulePrefixName}module.flow.${moduleClassNamePrefix}Flow.${moduleClassNamePrefix}Tasks.APROVADO;
import static ${package}.${modulePrefixName}module.flow.${moduleClassNamePrefix}Flow.${moduleClassNamePrefix}Tasks.REPROVADO;
import static ${package}.${modulePrefixName}module.flow.${moduleClassNamePrefix}Flow.${moduleClassNamePrefix}Tasks.SOLICITACAO_COM_PENDENCIAS;

@DefinitionInfo("${modulePrefixName}")
public class ${moduleClassNamePrefix}Flow extends RequirementFlowDefinition<FlowInstance> {

    public static final String CONCLUIR_PENDENCIA = "Concluir Pendência";

    public enum ${moduleClassNamePrefix}Tasks implements ITaskDefinition {

        ANALISAR("Analisar"),
        APROVADO("Aprovado"),
        REPROVADO("Reprovado"),
        SOLICITACAO_COM_PENDENCIAS("Solicitação com pendências");

        private String taskName;

        ${moduleClassNamePrefix}Tasks(String taskName) {
            this.taskName = taskName;
        }

        @Override
        public String getName() {
            return taskName;
        }
    }

    public ${moduleClassNamePrefix}Flow() {
        super(FlowInstance.class);
        this.setName(${moduleClassNamePrefix}Module.${moduleStringIDName}, "${moduleClassNamePrefix}");

    }

    @Override
    protected void buildFlow(@Nonnull RequirementFlowBuilder flow) {

        flow.addHumanTask(ANALISAR)
                .uiAccess(new PermissiveTaskAccessStrategy()).withExecutionPage(FormPage.class);

        flow.addHumanTask(SOLICITACAO_COM_PENDENCIAS).uiAccess(new PermissiveTaskAccessStrategy())
                .withExecutionPage(FormPage.class);

        flow.addEndTask(REPROVADO);
        flow.addEndTask(APROVADO);

        flow.setStartTask(ANALISAR);

        flow.from(ANALISAR).go("Solicitar ajustes", SOLICITACAO_COM_PENDENCIAS);
        flow.from(ANALISAR).go("Aprovar", APROVADO);
        flow.from(ANALISAR).go("Reprovar", REPROVADO);

        flow.from(SOLICITACAO_COM_PENDENCIAS).go(CONCLUIR_PENDENCIA, ANALISAR);
    }


}