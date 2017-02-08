#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${rootArtifactId}module.config;

import ${package}.${rootArtifactId}module.form.${capitalizedArtifactId}Form;
import ${package}.${rootArtifactId}module.spring.PersistenceConfiguration;
import ${package}.${rootArtifactId}module.wicket.${capitalizedArtifactId}Application;
import org.opensingular.flow.core.service.IFlowMetadataREST;
import org.opensingular.form.SType;
import org.opensingular.server.commons.config.IServerContext;
import org.opensingular.server.commons.config.SchedulerInitializer;
import org.opensingular.server.commons.service.IServerMetadataREST;
import org.opensingular.server.commons.spring.SingularDefaultPersistenceConfiguration;
import org.opensingular.server.commons.wicket.SingularApplication;
import org.opensingular.server.p.commons.config.*;
import org.opensingular.server.p.commons.flow.rest.DefaultPServerMetadataREST;

import java.util.ArrayList;
import java.util.List;

public class ${capitalizedArtifactId}ModuleInitializer implements PSingularInitializer {

    public PWebInitializer webConfiguration() {
        return new PWebInitializer() {
            @Override
            protected Class<? extends SingularApplication> getWicketApplicationClass(IServerContext iServerContext) {
                return ${capitalizedArtifactId}Application.class;
            }
        };
    }

    public PSpringHibernateInitializer springHibernateConfiguration() {
        return new PSpringHibernateInitializer() {
            @Override
            protected Class<? extends SingularDefaultPersistenceConfiguration> persistenceConfiguration() {
                return PersistenceConfiguration.class;
            }
        };
    }

    public PFormInitializer formConfiguration() {
        return new PFormInitializer() {

            @Override
            protected List<Class<? extends SType<?>>> getTypes() {
                return new ArrayList<Class<? extends SType<?>>>() {
                    {
                        add(${capitalizedArtifactId}Form.class);
                    }
                };
            }
        };

    }

    public PFlowInitializer flowConfiguration() {
        return new PFlowInitializer() {

            @Override
            public Class<? extends IServerMetadataREST> serverMetadataProvider() {
                return DefaultPServerMetadataREST.class;
            }

            @Override
            public Class<? extends IFlowMetadataREST> flowMetadataProvider() {
                return null;
            }

            @Override
            public String[] definitionsBasePackage() {
                return new String[]{"${package}.${rootArtifactId}module.flow"};
            }

            @Override
            public String processGroupCod() {
                return "${rootArtifactId.toUpperCase()}MODULE";
            }
        };
    }

    @Override
    public SchedulerInitializer schedulerConfiguration() {
        return null;
    }

}
