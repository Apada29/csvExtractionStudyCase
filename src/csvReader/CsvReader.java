package csvReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import bean.Person;
import helper.CsvReaderHelper;

/**
 * Handles data extraction from a .csv file.
 * 
 * @author Apada
 *
 */
public class CsvReader {

	private File csvFile;

	private Class<Person> javaBean;

	public CsvReader(File csvFile, Class<Person> javaBean) {
		this.csvFile = csvFile;
		this.javaBean = javaBean;
	}

	/**
	 * Retrieves data from .csv file.
	 * 
	 * @return list of persons
	 */
	public List<Person> getPersons() {

		List<Person> personList = new ArrayList<>();

		Map<Integer, String> csvMatch = CsvReaderHelper.mapCsvColumns(javaBean);

		try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
			String line = "";
			while ((line = reader.readLine()) != null) {
				String[] lineValues = line.split(CsvReaderHelper.getCsvSeparator(javaBean));

				Person person = new Person();
				for (int i = 0; i < lineValues.length; i++) {
					BeanUtils.setProperty(person, csvMatch.get(i + 1), lineValues[i]);
				}
				personList.add(person);
			}
		} catch (IOException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			e.printStackTrace();
		}

		return personList;
	}

}
