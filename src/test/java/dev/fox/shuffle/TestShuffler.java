package dev.fox.shuffle;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import dev.fox.data.LoadCSV;
import dev.fox.data.LoadPeople;
import dev.fox.model.Gifter;
import dev.fox.model.Person;

public class TestShuffler {

	@Test
	public void test_hasException() {
		List<Person> persons = Arrays.asList(new Person("Lee Ann"));
		List<Gifter> gifters = Arrays.asList(new Gifter("Rose", Arrays.asList("Lee Ann")));
		assertTrue(Shuffler.hasException(persons, gifters));
		
		
	}
	
	@Test
	public void test_shuffle() {
		try {
			List<Person> people = LoadPeople.getPeople();
			String[] origPeeps = new String[people.size()];
			int index = 0;
			for (Person p : people) {
				origPeeps[index] = p.getName();
				index++;
			}
			
			List<Gifter> gifters = LoadCSV.getGifters();
			List<Person> shuffledPeeps = Shuffler.shuffle(people, gifters);
			boolean isCorrect = false;
			for (int i=0; i<shuffledPeeps.size(); i++) {
				if (!origPeeps[i].equals(shuffledPeeps.get(i).getName())) {
					isCorrect = true;
				}
			}
			assertTrue(isCorrect);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
