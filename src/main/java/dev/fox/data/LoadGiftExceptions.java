package dev.fox.data;

import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

import dev.fox.model.GiftException;
import dev.fox.util.Utility;

public class LoadGiftExceptions {
	
	public static List<GiftException> getGiftExceptions() throws Exception {
		List<GiftException> exceptions = new ArrayList<GiftException>();
		CSVReader reader = null;
		
		try {
			reader = LoadCSV.getFile(Utility.CSV_EXCEPTIONS);
			
			int counter = 0;  //skip header
			
			for (String[] line : reader.readAll()) {
				if (counter > 0) {
					GiftException ge = new GiftException(line[0], line[1]);
					exceptions.add(ge);
				}
				counter++;
			}
		} catch (Exception e) {		
			e.printStackTrace();
		} finally {
			try { reader.close(); } catch (Exception e) { }
		}
		
		return exceptions;		
	}
	
}
