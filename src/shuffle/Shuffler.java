package shuffle;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import data.LoadCSV;
import data.LoadPeople;
import data.SaveOutput;
import model.Gifter;
import model.Person;
import util.Utility;

public class Shuffler {
	
	private static void saveOutput(String fileName, List<Gifter> gifters) throws Exception {
		SaveOutput so = new SaveOutput(Utility.CSV_PREV_GIFTEES, fileName);
		List<String[]> giftArray = new ArrayList<String[]>();
		for (Gifter g : gifters) {
			String[] arr = new String[3];
			arr[0] = g.getName();
			arr[1] = Calendar.getInstance().get(Calendar.YEAR) + "";
			arr[2] = g.getCurrentGiftee();
			giftArray.add(arr);
		}
		so.save(giftArray);
	}
	
	private static void updateGifterList(List<Person> people, List<Gifter> gifters) {
		for (int i=0; i<people.size(); i++) {
			gifters.get(i).setCurrentGiftee(people.get(i).getName());
		}
	}
	
	private static void shuffle(List<Person> people, List<Gifter> gifters) {
		Collections.shuffle(people);
		if (hasException(people, gifters)) {
			shuffle(people, gifters);
		}
	}
	
	private static boolean hasException(List<Person> people, List<Gifter> gifters) {

		for (int i=0; i<gifters.size(); i++) {
			Gifter gifter = gifters.get(i);
			List<String> exceptions = gifter.getExceptions();
			for (String exception : exceptions) {
				if (people.get(i).getName().equals(exception) || people.get(i).getName().equals(gifter.getName())) {
					return true;
				}
			}	
		}
		return false;
	}
	
	public static void main(String[] args) {
		try {
			
			List<Person> people = LoadPeople.getPeople();			
			List<Gifter> gifters = LoadCSV.getGifters();	
			
			shuffle(people, gifters);
			updateGifterList(people, gifters);
			
			for (Gifter g : gifters) {
				System.out.println(g.getName() + " : " + g.getCurrentGiftee());
			}
			
			saveOutput(Utility.CSV_PREV_GIFTEES, gifters);
			
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
}
