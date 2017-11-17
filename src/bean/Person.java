package bean;

import annotation.CSVColumn;
import annotation.FileMetaData;

@FileMetaData(separator = ",")
public class Person {

	@CSVColumn(indx = 1)
	private String firstName;

	@CSVColumn(indx = 2)
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
