#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${modulePrefixName}module.form;

import java.util.Arrays;
import java.util.function.Predicate;
import javax.annotation.Nonnull;

import org.opensingular.form.SIComposite;
import org.opensingular.form.SInfoType;
import org.opensingular.form.SInstance;
import org.opensingular.form.STypeComposite;
import org.opensingular.form.TypeBuilder;
import org.opensingular.form.type.core.STypeBoolean;
import org.opensingular.form.type.core.STypeString;
import org.opensingular.form.view.SViewByBlock;

import static org.opensingular.form.util.SingularPredicates.typeValueIsTrueAndNotNull;

@SInfoType(spackage = ${moduleClassNamePrefix}Package.class, name = "${moduleClassNamePrefix}")
public class ${moduleClassNamePrefix}Form extends STypeComposite<SIComposite> {

        public STypeBoolean radioBox;
        public STypeString descriptionTextArea;
        public STypeString typeSelection;

        @Override
        protected void onLoadType(@Nonnull TypeBuilder tb) {
            asAtr().displayString("Nova Solicitação");

            radioBox = addFieldBoolean("radioBox");
            radioBox.withRadioView("Sim", "Não")
                .asAtr().required().label("Novo Usuário?").asAtrAnnotation().setAnnotated()
                .asAtrBootstrap().colPreference(2);

            typeSelection = addFieldString("typeSelection");
            typeSelection.selectionOf(Profissoes.valuesOfDescricao()).asAtr().label("Campo Seleção").required(true);
            typeSelection.asAtr().dependsOn(radioBox).exists(isNewUser()).asAtrAnnotation().setAnnotated()
                .asAtrBootstrap().colPreference(3);

            descriptionTextArea = addFieldString("descriptionTextArea");
            descriptionTextArea
                .asAtr().required().label("Descrição")
                .asAtrBootstrap().colPreference(12);
            descriptionTextArea
                .withTextAreaView(sViewTextArea -> sViewTextArea.setLines(4))
                .asAtr().maxLength(4000).asAtrAnnotation().setAnnotated();


            this.withView(new SViewByBlock(), block ->
            block.newBlock("Campos Básicos")
                .add(radioBox)
                .add(typeSelection)
                .add(descriptionTextArea)
            );
        }

        private Predicate<SInstance> isNewUser() {
            return typeValueIsTrueAndNotNull(radioBox);
        }



        public enum Profissoes {

            DESENVOLVEDOR("Desenvolvedor"),
            ANALISTA("Analista"),
            GERENTE("Gerente"),
            CEO("Diretor executivo");

            private String descricao;

            Profissoes(String descricao) {
                this.descricao = descricao;
            }

            @Nonnull
            public String getDescricao() {
                return descricao;
            }

            public static String[] valuesOfDescricao(){
                return Arrays.stream(values()).map(v -> v.descricao).toArray(String[]::new);
            }
        }
}

