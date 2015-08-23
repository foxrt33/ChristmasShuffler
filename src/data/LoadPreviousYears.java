package data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVReader;

import model.PreviousGiftees;

public class LoadPreviousYears {

	public static final int YEARS_TO_CHECK = 3;
	private static final String filePreviousYears = "resources/previousYears.txt";
	
	public static Map<String, List<PreviousGiftees>> getPreviousGiftees() {
		Map<String, List<PreviousGiftees>> previousGiftees = new HashMap<String, List<PreviousGiftees>>();
		CSVReader reader = null;
		
		int curYear = getCurrentYear();
		try {		
			reader = LoadCSV.getFile(filePreviousYears);
			List<PreviousGiftees> pg;
			int counter = 0;
			for (String[] line : reader.readAll()) {
				if (counter > 0) {  //skip header
					String gifter = line[0];
					int year = Integer.parseInt(line[1]);
					String giftee = line[2];
					
					if (curYear - year <= YEARS_TO_CHECK) {
						PreviousGiftees prevGiftee = new PreviousGiftees(gifter, giftee, year);		
						pg = previousGiftees.get(gifter);
						if (pg != null) {
							pg.add(prevGiftee);
						} else {
							pg = new ArrayList<PreviousGiftees>();
							pg.add(prevGiftee);
						}
						previousGiftees.put(gifter, pg);
					}	
				}
				counter++;		
			}		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { reader.close(); } catch (IOException e) { }
		}
		
		return previousGiftees;
	}
	
	private static int getCurrentYear() {
		return Calendar.getInstance().get(Calendar.YEAR);
	}

}
