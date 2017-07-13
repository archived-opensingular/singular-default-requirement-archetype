#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${modulePrefixName}module.flow;

import ${package}.${modulePrefixName}module.${moduleClassNamePrefix}Module;
import org.opensingular.flow.core.DefinitionInfo;
import org.opensingular.flow.core.ITaskDefinition;
import org.opensingular.flow.core.FlowInstance;
import org.opensingular.flow.core.defaults.NullTaskAccessStrategy;
import org.opensingular.server.commons.flow.SingularServerTaskPageStrategy;
import org.opensingular.server.commons.flow.builder.RequirementFlowBuilder;
import org.opensingular.server.commons.wicket.view.form.FormPage;
import org.opensingular.server.p.commons.flow.definition.RequirementFlowDefinition;

import javax.annotation.Nonnull;

import static ${package}.${modulePrefixName}module.flow.${moduleClassNamePrefix}Flow.${moduleClassNamePrefix}Tasks.ANALISAR;
import static ${package}.${modulePrefixName}module.flow.${moduleClassNamePrefix}Flow.${moduleClassNamePrefix}Tasks.APROVADO;
import static ${package}.${modulePrefixName}module.flow.${moduleClassNamePrefix}Flow.${moduleClassNamePrefix}Tasks.REPROVADO;


@DefinitionInfo("${modulePrefixName}")
public class ${moduleClassNamePrefix}Flow extends RequirementFlowDefinition<FlowInstance> {

    public enum ${moduleClassNamePrefix}Tasks implements ITaskDefinition {

        ANALISAR("Analisar"),
        APROVADO("Aprovado"),
        REPROVADO("Reprovado");

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
        super(ProcessInstance.class);
        this.setName(${moduleClassNamePrefix}Module.${moduleStringIDName}, "${moduleClassNamePrefix}");

    }


    @Override
    protected void buildFlow(@Nonnull RequirementFlowBuilder builder) {

        builder.addPeopleTask(ANALISAR)
                .addAccessStrategy(new NullTaskAccessStrategy())
                .withExecutionPage(SingularServerTaskPageStrategy.of(FormPage.class));

        builder.addEndTask(REPROVADO);
        builder.addEndTask(APROVADO);


        builder.setStartTask(ANALISAR);

        builder.from(ANALISAR).go("Aprovar", APROVADO);
        builder.from(ANALISAR).go("Reprovar", REPROVADO);
    }

}