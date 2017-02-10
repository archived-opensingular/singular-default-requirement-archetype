#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${modulePrefixName}module.form;

import org.opensingular.form.SIComposite;
import org.opensingular.form.SInfoType;
import org.opensingular.form.STypeComposite;
import org.opensingular.form.TypeBuilder;
import org.opensingular.form.type.core.STypeString;
import org.opensingular.form.view.SViewByBlock;


@SInfoType(spackage = ${modulePrefixClassName}Package.class, newable = true, name = "Requerimento")
public class ${modulePrefixClassName}Form extends STypeComposite<SIComposite> {

    public STypeString nome;

    @Override
    protected void onLoadType(TypeBuilder tb) {

        nome = this.addFieldString("nome");

        this
                .asAtr()
                .label("Requerimento")
                .displayString("Requerimento de ${symbol_dollar}{nome}")
                .asAtrAnnotation()
                .setAnnotated();

        nome.asAtr()
                .label("Nome completo")
                .maxLength(200)
                .required();

        this
                .withView(new SViewByBlock(), v -> v
                        .newBlock("Informações pessoais")
                        .add(nome));

    }
}
