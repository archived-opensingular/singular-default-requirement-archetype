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

@SInfoType(spackage = ${modulePrefixClassName}Package.class, name = "${modulePrefixClassName}")
public class ${modulePrefixClassName}Form extends STypeComposite<SIComposite> {

    public STypeString nome;

    @Override
    protected void onLoadType(TypeBuilder tb) {
        this.asAtr().label("Formulário de Requerimento")
                .displayString("Requerimento de ${symbol_dollar}{nome!}");

        this.asAtrAnnotation().setAnnotated();

        nome = this.addFieldString("nome");

        this.withView(new SViewByBlock(),
                v -> v.newBlock("Dados Pessoais").add(nome));

    }
}

