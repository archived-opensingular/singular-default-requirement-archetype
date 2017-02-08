#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.examplemodule.form;

import org.opensingular.form.PackageBuilder;
import org.opensingular.form.SInfoPackage;
import org.opensingular.form.SPackage;

@SInfoPackage(name = ExamplePackage.PACKAGE_NAME)
public class ExamplePackage extends SPackage {

    public static final String PACKAGE_NAME = "${package}.example";

    @Override
    protected void onLoadPackage(PackageBuilder pb) {
        super.onLoadPackage(pb);
        pb.createType(ExampleForm.class);
    }

}