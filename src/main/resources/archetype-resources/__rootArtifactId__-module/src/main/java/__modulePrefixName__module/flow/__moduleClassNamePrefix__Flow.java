#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${modulePrefixName}module.flow;

import ${package}.${modulePrefixName}module.${moduleClassNamePrefix}Module;
import org.opensingular.flow.core.DefinitionInfo;
import org.opensingular.flow.core.ITaskDefinition;
import org.opensingular.flow.core.ProcessInstance;
import org.opensingular.flow.core.defaults.NullTaskAccessStrategy;
import org.opensingular.server.commons.flow.SingularServerTaskPageStrategy;
import org.opensingular.server.commons.flow.builder.FlowBuilderPetition;
import org.opensingular.server.commons.wicket.view.form.FormPage;
import org.opensingular.server.p.commons.flow.definition.ServerProcessDefinition;

import javax.annotation.Nonnull;

import static ${package}.${modulePrefixName}module.flow.${moduleClassNamePrefix}Flow.${moduleClassNamePrefix}Tasks.ANALISAR;
import static ${package}.${modulePrefixName}module.flow.${moduleClassNamePrefix}Flow.${moduleClassNamePrefix}Tasks.APROVADO;
import static ${package}.${modulePrefixName}module.flow.${moduleClassNamePrefix}Flow.${moduleClassNamePrefix}Tasks.REPROVADO;


@DefinitionInfo("${modulePrefixName}")
public class ${moduleClassNamePrefix}Flow extends ServerProcessDefinition<ProcessInstance> {

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

        @Override
        public String getKey() {
            return this.name();
        }

        @Override
        public boolean isNameEquals(String name) {
            return this.name().equals(name);
        }
    }

    public ${moduleClassNamePrefix}Flow() {
        super(ProcessInstance.class);
        this.setName(${moduleClassNamePrefix}Module.${moduleStringIDName}, "${moduleClassNamePrefix}");

    }


    @Override
    protected void buildFlow(@Nonnull FlowBuilderPetition builder) {

        builder.addPeopleTask(ANALISAR)
                .addAccessStrategy(new NullTaskAccessStrategy())
                .withExecutionPage(SingularServerTaskPageStrategy.of(FormPage.class));

        builder.addEnd(REPROVADO);
        builder.addEnd(APROVADO);


        builder.setStart(ANALISAR);

        worklist(builder.from(ANALISAR).go("Aprovar", APROVADO));
        worklist(builder.from(ANALISAR).go("Reprovar", REPROVADO));
    }

}