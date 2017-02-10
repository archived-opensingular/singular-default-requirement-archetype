#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${modulePrefixName}module.flow;

import org.opensingular.flow.core.DefinitionInfo;
import org.opensingular.flow.core.FlowMap;
import org.opensingular.flow.core.ProcessInstance;
import org.opensingular.flow.core.builder.FlowBuilderImpl;
import org.opensingular.flow.core.builder.ITaskDefinition;
import org.opensingular.flow.core.defaults.NullTaskAccessStrategy;
import org.opensingular.server.commons.flow.SingularServerTaskPageStrategy;
import org.opensingular.server.module.wicket.view.util.form.FormPage;
import org.opensingular.server.p.commons.flow.definition.SingularServerProcessDefinition;

import static ${package}.${modulePrefixName}module.flow.${modulePrefixClassName}Flow.${modulePrefixClassName}Tasks.FIM;
import static ${package}.${modulePrefixName}module.flow.${modulePrefixClassName}Flow.${modulePrefixClassName}Tasks.INICIO;

@DefinitionInfo("${modulePrefixName}")
public class ${modulePrefixClassName}Flow extends SingularServerProcessDefinition<ProcessInstance> {

    public enum ${modulePrefixClassName}Tasks implements ITaskDefinition {

        INICIO("Início"),
        FIM("Fim");

        private String taskName;

        ${modulePrefixClassName}Tasks(String taskName) {
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

    public ${modulePrefixClassName}Flow() {
        super(ProcessInstance.class);
    }

    @Override
    protected FlowMap createFlowMap() {

        FlowBuilderImpl builder = new FlowBuilderImpl(this);

        builder.addPeopleTask(INICIO)
                .addAccessStrategy(new NullTaskAccessStrategy())
                .withExecutionPage(SingularServerTaskPageStrategy.of(FormPage.class));

        builder.addEnd(FIM);
        builder.setStartTask(INICIO);

        worklist(builder.from(INICIO).go("Finalizar", FIM));

        return builder.build();
    }

}