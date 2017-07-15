package dev.fox.data;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import dev.fox.model.GiftException;

public class TestLoadGiftExceptions {

	@Test
	public void test_loadGiftExceptions() {
		try {
			List<GiftException> giftExceptions = LoadGiftExceptions.getGiftExceptions();
			assertEquals(giftExceptions.size(), 10);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
