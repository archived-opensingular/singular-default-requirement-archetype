#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${modulePrefixName}module.box;


import static ${package}.${modulePrefixName}module.flow.${moduleClassNamePrefix}Flow.${moduleClassNamePrefix}Tasks.SOLICITACAO_COM_PENDENCIAS;
import org.opensingular.lib.wicket.util.resource.DefaultIcons;
import org.opensingular.requirement.commons.box.BoxItemData;
import org.opensingular.requirement.commons.box.action.AbstractURLPopupBoxItemAction;
import org.opensingular.requirement.commons.config.IServerContext;
import org.opensingular.requirement.commons.config.PServerContext;
import org.opensingular.requirement.commons.form.FormAction;
import org.opensingular.requirement.commons.service.dto.DatatableField;
import org.opensingular.requirement.commons.service.dto.ItemBox;
import org.opensingular.requirement.module.ActionProviderBuilder;
import org.opensingular.requirement.module.BoxItemDataProvider;
import org.opensingular.requirement.module.provider.RequirementBoxItemDataProvider;
import org.opensingular.requirement.module.workspace.BoxDefinition;

import java.util.ArrayList;
import java.util.List;

public class ${moduleClassNamePrefix}CaixaPendencia implements BoxDefinition {

        @Override
        public boolean appliesTo(IServerContext context) {
            return PServerContext.REQUIREMENT.isSameContext(context);
        }

        @Override
        public ItemBox build(IServerContext context) {
            final ItemBox caixaEntrada = new ItemBox();
            caixaEntrada.setName("Pendências");
            caixaEntrada.setDescription("Caixa de Pendências");
            caixaEntrada.setIcone(DefaultIcons.WARNING);
            return caixaEntrada;
        }

        @Override
        public BoxItemDataProvider getDataProvider() {

        ActionProviderBuilder actionProvider = new ActionProviderBuilder()
            .addCustomActions((boxInfo, line, filter, list) -> list.addAction(new CumprirDiligenciaAction(line)))
            .addViewAction()
            .addHistoryAction();


            return new RequirementBoxItemDataProvider(Boolean.TRUE, actionProvider)
                .addTask(SOLICITACAO_COM_PENDENCIAS.getName());
        }

        @Override
        public List<DatatableField> getDatatableFields() {
            List<DatatableField> fields = new ArrayList<>();
            fields.add(DatatableField.of("NÚMERO", "codRequirement"));
            fields.add(DatatableField.of("Descrição", "description"));
            fields.add(DatatableField.of("Dt. Entrada", "processBeginDate"));
            fields.add(DatatableField.of("Situação", "situation"));
            fields.add(DatatableField.of("Dt. Situação", "situationBeginDate"));
            return fields;
        }

        public static class CumprirDiligenciaAction extends AbstractURLPopupBoxItemAction {
            public CumprirDiligenciaAction(BoxItemData line) {
                super("diligencia", "Cumprir pendência", DefaultIcons.PENCIL_SQUARE,
                    FormAction.FORM_FILL_WITH_ANALYSIS, line);
            }
        }

}
