package dev.fox.data;

import static org.junit.Assert.*;

import org.junit.Test;

import com.opencsv.CSVReader;

public class TestLoadCSV {

	@Test
	public void test_getFile() {
		try {
			CSVReader reader = LoadCSV.getFile("/Users/rosefox/Documents/xmas/people.txt");
			assertNotNull(reader);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
