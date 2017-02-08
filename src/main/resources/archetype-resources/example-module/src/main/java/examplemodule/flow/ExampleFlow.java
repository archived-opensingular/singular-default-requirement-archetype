#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.examplemodule.flow;

import org.opensingular.flow.core.DefinitionInfo;
import org.opensingular.flow.core.FlowMap;
import org.opensingular.flow.core.ProcessInstance;
import org.opensingular.flow.core.builder.FlowBuilderImpl;
import org.opensingular.flow.core.builder.ITaskDefinition;
import org.opensingular.flow.core.defaults.NullTaskAccessStrategy;
import org.opensingular.server.commons.flow.SingularServerTaskPageStrategy;
import org.opensingular.server.module.wicket.view.util.form.FormPage;
import org.opensingular.server.p.commons.flow.definition.SingularServerProcessDefinition;

import static ${package}.examplemodule.flow.ExampleFlow.ExampleTasks.FIM;
import static ${package}.examplemodule.flow.ExampleFlow.ExampleTasks.INICIO;

@DefinitionInfo("example")
public class ExampleFlow extends SingularServerProcessDefinition<ProcessInstance> {

    public enum ExampleTasks implements ITaskDefinition {

        INICIO("Início"),
        FIM("Fim");

        private String taskName;

        ExampleTasks(String taskName) {
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

    public ExampleFlow() {
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