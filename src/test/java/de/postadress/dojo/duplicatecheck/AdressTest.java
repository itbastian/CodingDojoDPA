package de.postadress.dojo.duplicatecheck;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AdressTest {
	
	@Test
	public void testIsAdressDuplicate() {
		Adress firstAdress = new Adress();
		Adress secondAdress= new Adress();
		
		assertTrue(firstAdress).isDuplicate(secondAdress));
	}

}
