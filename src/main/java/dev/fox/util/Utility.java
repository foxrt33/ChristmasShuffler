package dev.fox.util;

public class Utility {

	public enum TYPE {
		CSV,
		H2,
		MYSQL
	}
	
	public static final char DELIMITER = ';';
	
//	public static final String CSV_EXCEPTIONS = "/Users/rosefox/Documents/xmas/exceptions.txt";
//	public static final String CSV_PEOPLE = "/Users/rosefox/Documents/xmas/people.txt";
//	public static final String CSV_PREV_GIFTEES = "/Users/rosefox/Documents/xmas/previousYears.txt";
	
	public static final String CSV_EXCEPTIONS = "output/exceptions.txt";
	public static final String CSV_PEOPLE = "output/people.txt";
	public static final String CSV_PREV_GIFTEES = "output/previousYears.txt";
	
	public static final int YEARS_TO_CHECK = 3;
	
	
}
