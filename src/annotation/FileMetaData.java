package annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * FileMetaData annotation.
 * 
 * @author Apada
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface FileMetaData {

	String separator() default ",";
}
