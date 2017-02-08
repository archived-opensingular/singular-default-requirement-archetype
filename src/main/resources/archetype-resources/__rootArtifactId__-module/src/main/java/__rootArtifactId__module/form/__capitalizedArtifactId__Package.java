#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${rootArtifactId}module.form;

import org.opensingular.form.PackageBuilder;
import org.opensingular.form.SInfoPackage;
import org.opensingular.form.SPackage;

@SInfoPackage(name = ${capitalizedArtifactId}Package.PACKAGE_NAME)
public class ${capitalizedArtifactId}Package extends SPackage {

    public static final String PACKAGE_NAME = "${package}.${rootArtifactId}";

    @Override
    protected void onLoadPackage(PackageBuilder pb) {
        super.onLoadPackage(pb);
        pb.createType(${capitalizedArtifactId}Form.class);
    }

}