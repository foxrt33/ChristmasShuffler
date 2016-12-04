package dev.fox.util;

public class Utility {

	public enum ENV {
		DEV,
		PROD
	}
	
	public enum TYPE {
		CSV,
		H2,
		MYSQL
	}
	
	public static final String DEV_PATH="/Users/dev/Documents/workspace/ChristmasShuffler/src/main/resources/";
	public static final String PROD_PATH="../../";
	
	public static final String CSV_EXCEPTIONS = "output/exceptions.txt";
	public static final String CSV_PEOPLE = "output/people.txt";
	public static final String CSV_PREV_GIFTEES = "output/previousYears.txt";
	
	public static final int YEARS_TO_CHECK = 3;
	
	
}
