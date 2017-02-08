#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${rootArtifactId}module.flow;

import org.opensingular.flow.core.DefinitionInfo;
import org.opensingular.flow.core.FlowMap;
import org.opensingular.flow.core.ProcessInstance;
import org.opensingular.flow.core.builder.FlowBuilderImpl;
import org.opensingular.flow.core.builder.ITaskDefinition;
import org.opensingular.flow.core.defaults.NullTaskAccessStrategy;
import org.opensingular.server.commons.flow.SingularServerTaskPageStrategy;
import org.opensingular.server.module.wicket.view.util.form.FormPage;
import org.opensingular.server.p.commons.flow.definition.SingularServerProcessDefinition;

import static ${package}.${rootArtifactId}module.flow.${capitalizedArtifactId}Flow.${capitalizedArtifactId}Tasks.FIM;
import static ${package}.${rootArtifactId}module.flow.${capitalizedArtifactId}Flow.${capitalizedArtifactId}Tasks.INICIO;

@DefinitionInfo("${rootArtifactId}")
public class ${capitalizedArtifactId}Flow extends SingularServerProcessDefinition<ProcessInstance> {

    public enum ${capitalizedArtifactId}Tasks implements ITaskDefinition {

        INICIO("Início"),
        FIM("Fim");

        private String taskName;

        ${capitalizedArtifactId}Tasks(String taskName) {
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

    public ${capitalizedArtifactId}Flow() {
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