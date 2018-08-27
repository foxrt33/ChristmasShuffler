package dev.fox.data;

import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVReader;

import dev.fox.model.GiftException;
import dev.fox.model.Gifter;
import dev.fox.model.Person;
import dev.fox.model.PreviousGiftees;
import dev.fox.util.Utility;

public class LoadCSV {

	private static List<Person> people;
	private static List<GiftException> exceptions;
	private static Map<String, List<PreviousGiftees>> gifterToPrevGiftees;
	private static LoadCSV loader = null;
	private LoadCSV() {}
	
	public static LoadCSV getCSVLoader() {
		if (loader == null) {
			loader = new LoadCSV();
		}
		return loader;
	}
	
	public CSVReader getFile(String path) throws Exception {
		InputStream is = getClass().getClassLoader()
                .getResourceAsStream(path);
		return new CSVReader(new InputStreamReader(is), Utility.DELIMITER);
	}
	
	private static void loadData() throws Exception {
		people = LoadPeople.getPeople();
		exceptions = LoadGiftExceptions.getGiftExceptions();
		gifterToPrevGiftees = LoadPreviousYears.getPreviousGiftees();
	}
	
	public static List<Gifter> getGifters() throws Exception {
		loadData();
		return configureGifters();
	}
	
	private static List<Gifter> configureGifters() {
		List<Gifter> gifters = new ArrayList<Gifter>();
		
		for (Person p : people) {
			Gifter g = new Gifter();
			List<String> exemptList = new ArrayList<String>();
			
			for (GiftException ge : exceptions) {
				if (ge.getPerson().equals(p.getName())) {
					exemptList.add(ge.getGifteeException());
				}
			}
			
			List<PreviousGiftees> prevGiftees = gifterToPrevGiftees.get(p.getName());
			for (PreviousGiftees pg : prevGiftees) {
				exemptList.add(pg.getGiftee());
			}
			g.setName(p.getName());
			g.setExceptions(exemptList);
			gifters.add(g);
		}
		
		return gifters;
	}
	
}
