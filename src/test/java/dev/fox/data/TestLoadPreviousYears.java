package dev.fox.data;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import dev.fox.model.PreviousGiftees;

public class TestLoadPreviousYears {

	@Test
	public void test_loadPreviousYears() {
		Map<String, List<PreviousGiftees>> pg = LoadPreviousYears.getPreviousGiftees();
		List<PreviousGiftees> list = pg.get("Rose");
		System.out.println(list.get(0).getGiftee());
		assertTrue(list.get(0).getGiftee().equals("Janet"));
		
	}
}
