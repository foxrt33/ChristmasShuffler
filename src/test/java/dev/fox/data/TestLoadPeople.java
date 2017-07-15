package dev.fox.data;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import dev.fox.model.Person;

public class TestLoadPeople {

	
	@Test
	public void test_loadPeople() {
		try {
			List<Person> peeps = LoadPeople.getPeople();
			assertNotNull(peeps);
			assertEquals(peeps.size(), 14);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
