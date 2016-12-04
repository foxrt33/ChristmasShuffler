package dev.fox.data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

import dev.fox.model.Person;
import dev.fox.util.Utility;

public class LoadPeople {
	
	public static List<Person> getPeople(Utility.ENV env) throws Exception {
		List<Person> people = new ArrayList<Person>();
		CSVReader reader = null;
		try {
			if (env == Utility.ENV.DEV) {
				reader = LoadCSV.getFile(Utility.DEV_PATH + Utility.CSV_PEOPLE);
			} else {
				reader = LoadCSV.getFile(Utility.PROD_PATH + Utility.CSV_PEOPLE);
			}
			
			
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
