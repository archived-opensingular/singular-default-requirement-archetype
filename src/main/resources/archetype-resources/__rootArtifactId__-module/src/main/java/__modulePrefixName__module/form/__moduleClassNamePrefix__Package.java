#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${modulePrefixName}module.form;

import org.opensingular.form.SInfoPackage;
import org.opensingular.form.SPackage;

@SInfoPackage(name = ${moduleClassNamePrefix}Package.PACKAGE_NAME)
public class ${moduleClassNamePrefix}Package extends SPackage {

    public static final String PACKAGE_NAME = "${package}.form";

}