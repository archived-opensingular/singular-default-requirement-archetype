#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId}.config;

import ${package}.${artifactId}.spring.PersistenceConfiguration;
import ${package}.${artifactId}.wicket.AnalysisApplication;
import ${package}.${artifactId}.wicket.PetitionApplication;
import org.opensingular.server.commons.config.IServerContext;
import org.opensingular.server.commons.config.SchedulerInitializer;
import org.opensingular.server.commons.spring.SingularDefaultPersistenceConfiguration;
import org.opensingular.server.commons.wicket.SingularApplication;
import org.opensingular.server.core.config.AttachmentGCSchedulerInitializer;
import org.opensingular.server.core.config.MailSenderSchedulerInitializer;
import org.opensingular.server.p.commons.config.PFlowInitializer;
import org.opensingular.server.p.commons.config.PFormInitializer;
import org.opensingular.server.p.commons.config.PServerContext;
import org.opensingular.server.p.commons.config.PSingularInitializer;
import org.opensingular.server.p.commons.config.PSpringHibernateInitializer;
import org.opensingular.server.p.commons.config.PWebInitializer;

public class ServerInitializer implements PSingularInitializer {

    public PWebInitializer webConfiguration() {
        return new PWebInitializer() {
            @Override
            protected Class<? extends SingularApplication> getWicketApplicationClass(IServerContext iServerContext) {
                 if (PServerContext.WORKLIST.equals(iServerContext)){
                     return AnalysisApplication.class;
                } else if (PServerContext.PETITION.equals(iServerContext)){
                     return PetitionApplication.class;
                 }
                return null;
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
        return null;
    }

    public PFlowInitializer flowConfiguration() {
        return null;
    }

    public SchedulerInitializer schedulerConfiguration() {
        return new SchedulerInitializer() {
            @Override
            public Class<?> mailConfiguration() {
                return MailSenderSchedulerInitializer.class;
            }

            @Override
            public Class<?> attachmentGCConfiguration() {
                return AttachmentGCSchedulerInitializer.class;
            }
        };
    }

}
