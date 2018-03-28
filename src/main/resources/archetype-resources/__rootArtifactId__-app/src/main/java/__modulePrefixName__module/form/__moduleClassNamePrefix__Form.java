#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${modulePrefixName}module.form;

import javax.annotation.Nonnull;

import org.opensingular.form.SIComposite;
import org.opensingular.form.SInfoType;
import org.opensingular.form.STypeComposite;
import org.opensingular.form.TypeBuilder;
import org.opensingular.form.view.SViewByBlock;

@SInfoType(spackage = ${moduleClassNamePrefix}Package.class, name = "${moduleClassNamePrefix}")
public class ${moduleClassNamePrefix}Form extends STypeComposite<SIComposite> {

        public ${moduleClassNamePrefix}STBasicFields basicFields;

        @Override
        protected void onLoadType(@Nonnull TypeBuilder tb) {
        asAtr().displayString("Nova Solicitação");

        basicFields = addField("basicFields", ${moduleClassNamePrefix}STBasicFields.class);

        this.withView(new SViewByBlock(), block ->
            block.newBlock("Campos Básicos").add(basicFields));
        }
}

