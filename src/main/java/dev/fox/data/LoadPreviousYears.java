package dev.fox.data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVReader;

import dev.fox.model.PreviousGiftees;
import dev.fox.util.Utility;

public class LoadPreviousYears {
	
	
	
	public static Map<String, List<PreviousGiftees>> getPreviousGiftees() {
		Map<String, List<PreviousGiftees>> previousGiftees = new HashMap<String, List<PreviousGiftees>>();
		CSVReader reader = null;
		
		int curYear = getCurrentYear();
		try {		
			reader = LoadCSV.getCSVLoader().getFile(Utility.CSV_PREV_GIFTEES);
			List<PreviousGiftees> pg;
			int counter = 0;
			for (String[] line : reader.readAll()) {
				if (counter > 0) {  //skip header
					String gifter = line[0];
					int year = Integer.parseInt(line[1]);
					String giftee = line[2];
					
					if (curYear - year <= Utility.YEARS_TO_CHECK) {
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
