package helper;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import annotation.CSVColumn;
import annotation.FileMetaData;
import bean.Person;

/**
 * Helper class for csv extraction.
 * 
 * @author Apada
 *
 */
public class CsvReaderHelper {

	private CsvReaderHelper() {
	}

	/**
	 * Maps csv columns to bean properties.
	 * 
	 * @param javaBean
	 * @return
	 */
	public static Map<Integer, String> mapCsvColumns(Class<Person> javaBean) {

		Map<Integer, String> csvMatch = new HashMap<>();

		for (Field field : javaBean.getDeclaredFields()) {
			if (field.isAnnotationPresent(CSVColumn.class)) {
				CSVColumn csvColumnAnnotation = field.getAnnotation(CSVColumn.class);
				csvMatch.put(csvColumnAnnotation.indx(), field.getName());
			}
		}
		return csvMatch;
	}

	/**
	 * Determines csv separator value: from annotated bean or default annotation value.
	 * 
	 * @param javaBean
	 * @return separator
	 * @throws NoSuchMethodException
	 */
	public static String getCsvSeparator(Class<Person> javaBean) throws NoSuchMethodException {

		if (javaBean.isAnnotationPresent(FileMetaData.class)) {
			return ((FileMetaData) javaBean.getAnnotation(FileMetaData.class)).separator();
		}
		return (String) ((FileMetaData.class).getMethod("separator")).getDefaultValue();

	}
}
