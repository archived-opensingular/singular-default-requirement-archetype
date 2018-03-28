#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${modulePrefixName}module.form;

import java.util.function.Predicate;
import javax.annotation.Nonnull;

import org.opensingular.form.SIComposite;
import org.opensingular.form.SInfoType;
import org.opensingular.form.SInstance;
import org.opensingular.form.STypeComposite;
import org.opensingular.form.TypeBuilder;
import org.opensingular.form.type.core.STypeBoolean;
import org.opensingular.form.type.core.STypeString;
import static org.opensingular.form.util.SingularPredicates.typeValueIsTrueAndNotNull;

@SInfoType(spackage = ${moduleClassNamePrefix}Package.class)
public class ${moduleClassNamePrefix}STBasicFields extends STypeComposite<SIComposite> {
        public STypeBoolean radioBox;
        public STypeString  descriptionTextArea;
        public STypeString typeSelection;

        @Override
        protected void onLoadType(@Nonnull TypeBuilder tb) {
        asAtrAnnotation().setAnnotated();

        radioBox = addFieldBoolean("radioBox");
        radioBox.withRadioView("Sim", "Não")
            .asAtr().required().label("Novo Usuário?");

        descriptionTextArea = addFieldString("descriptionTextArea");
        descriptionTextArea
            .asAtr().required().label("Descrição")
            .asAtrBootstrap().colPreference(12);
        descriptionTextArea
            .withTextAreaView(sViewTextArea -> sViewTextArea.setLines(4))
            .asAtr().maxLength(4000);

        typeSelection = addFieldString("typeSelection");
        typeSelection.selectionOf(createOptions()).asAtr().label("Campo Seleção").required(true);
        typeSelection.asAtr().dependsOn(radioBox).exists(isNewUser());


        }

        private Predicate<SInstance> isNewUser() {
            return typeValueIsTrueAndNotNull(radioBox);
        }

        private String[] createOptions() {
            String[] options = new String[5];
            for (int i = 1; i <= 5; i++) {
                options[i - 1] = "Opção " + i;
            }
            return options;
        }
}
