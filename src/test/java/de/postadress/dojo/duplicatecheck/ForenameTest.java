package de.postadress.dojo.duplicatecheck;

import static org.junit.Assert.*;

import org.junit.Test;

public class ForenameTest {

	@Test
	public void testIsDuplicateOfEquals() {
		Forename forename1 = new Forename("Karsten");

		Forename forename2 = new Forename("Karsten");
		assertEquals(forename1.getSimilarityTo(forename2).getSimilarityValue(),
				100);
	}

	@Test
	public void testIsDuplicateOfNotEquals() {
		Forename forename1 = new Forename("Karsten");

		Forename forename2 = new Forename("Karsten2");
		assertEquals(forename1.getSimilarityTo(forename2).getSimilarityValue(),
				0);
	}

}
