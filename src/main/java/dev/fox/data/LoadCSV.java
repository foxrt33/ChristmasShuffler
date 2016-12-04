package dev.fox.data;

import java.io.FileReader;
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
	
	public static CSVReader getFile(String path) throws Exception {
		return new CSVReader(new FileReader(path), ';', '"');
	}
	
	private static void loadData(Utility.ENV env) throws Exception {
		people = LoadPeople.getPeople(env);
		exceptions = LoadGiftExceptions.getGiftExceptions(env);
		gifterToPrevGiftees = LoadPreviousYears.getPreviousGiftees(env);
	}
	
	public static List<Gifter> getGifters(Utility.ENV env) throws Exception {
		loadData(env);
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
