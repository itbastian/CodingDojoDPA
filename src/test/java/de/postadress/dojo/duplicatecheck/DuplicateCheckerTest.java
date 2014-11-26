package de.postadress.dojo.duplicatecheck;

import static org.junit.Assert.*;

import org.junit.Test;

public class DuplicateCheckerTest {

	@Test
	public void testSingleForname() {
		Forename forename1 = new Forename("Karsten");

		Forename forename2 = new Forename("Karsten");

		DuplicateChecker checker = new DuplicateChecker();

		Similarity similarityOfFornames = checker.checkForDuplicate(forename1,
				forename2);
		assertEquals(Similarity.FULL_SIMILARITY, similarityOfFornames);
	}
}
