package data;

import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

import model.GiftException;

public class LoadGiftExceptions {

	private static String exceptionFile = "resources/exceptions.txt";
	
	public static List<GiftException> getGiftExceptions() throws Exception {
		List<GiftException> exceptions = new ArrayList<GiftException>();
		CSVReader reader = null;
		
		try {
			reader = LoadCSV.getFile(exceptionFile);
			
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
