#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}module.form;

import org.opensingular.form.SInfoPackage;
import org.opensingular.form.SPackage;

@SInfoPackage(name = AntaqPackage.PACKAGE_NAME)
public class AntaqPackage extends SPackage {

    public static final String PACKAGE_NAME = "${package}.form";

}