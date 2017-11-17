package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;
import java.util.List;

import org.junit.jupiter.api.Test;

import bean.Person;
import csvReader.CsvReader;

public class CsvReaderTest {

	/**
	 * Positive test: extract data from a .csv file.
	 * <p>
	 * Expected content: [Person [firstName=John, lastName=Doe], Person
	 * [firstName=Jane, lastName=Doe], Person [firstName=Peter, lastName=Parker]]
	 */
	@Test
	public void testCsvExtraction() {

		File csvFile = new File(getClass().getResource("team.csv").getPath());

		CsvReader csvReader = new CsvReader(csvFile, Person.class);
		List<Person> persons = csvReader.getPersons();

		assertNotNull(persons);
		assertEquals(persons.size(), 3);
		System.out.println(persons.toString());
	}

}
