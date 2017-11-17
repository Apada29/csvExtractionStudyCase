package annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * CSVColumn annotation.
 * 
 * @author Apada
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface CSVColumn {

	int indx() default 1;
}
