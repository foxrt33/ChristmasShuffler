package data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

import model.Person;
import util.Utility;

public class LoadPeople {
	
	public static List<Person> getPeople() throws Exception {
		List<Person> people = new ArrayList<Person>();
		CSVReader reader = null;
		try {
			reader = LoadCSV.getFile(Utility.CSV_PEOPLE);
			
			int counter = 0;
			
			for (String[] line : reader.readAll()) {
				if (counter > 0) {
					Person p = new Person(line[0]);
					people.add(p);
				}
				counter++;
			}
		} catch (Exception e) {		
			e.printStackTrace();
		} finally {
			try { reader.close(); } catch (IOException e) { }
		}
		
		return people;
		
	}
}
