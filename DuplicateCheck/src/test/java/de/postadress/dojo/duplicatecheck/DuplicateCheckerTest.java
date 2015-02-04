package de.postadress.dojo.duplicatecheck;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class DuplicateCheckerTest {

	private DuplicateChecker checker;

	@Before
	public void setup() {
		checker = new DuplicateChecker(new SimpleSimilarityFunction());
	}

	@Test
	public void testSingleForname() {
		Forename forename1 = new Forename("Karsten");

		Forename forename2 = new Forename("Karsten");

		boolean duplicate = checker.isDuplicate(forename1, forename2,
				Similarity.FULL_SIMILARITY);
		assertTrue(duplicate);
	}

	public void testMinimumSimilarity() {
		Forename forename1 = new Forename("Karsten");
		Forename forename2 = new Forename("C");

		boolean duplicate = checker.isDuplicate(forename1, forename2,
				Similarity.ZERO_SIMILARITY);
		assertFalse(duplicate);
	}

	@Test
	public void testDuplicate() {
		// given
		List<Forename> forenameList = new ArrayList<Forename>();
		forenameList.add(new Forename("Karsten"));
		forenameList.add(new Forename("Karsten"));

		// when
		List<Forename> forenameDuplicates;
		forenameDuplicates = checker.findDuplicates(forenameList);

		// then
		assertTrue(forenameDuplicates.size() == 1);

	}

	@Test
	public void testDuplicateKomplex() {
		// given
		List<Forename> forenameList = new ArrayList<Forename>();
		forenameList.add(new Forename("Karsten"));
		forenameList.add(new Forename("Andree"));
		forenameList.add(new Forename("Hans"));
		forenameList.add(new Forename("Franz"));
		forenameList.add(new Forename("Karsten"));
		forenameList.add(new Forename("Hans"));
		forenameList.add(new Forename("Bla"));
		forenameList.add(new Forename("Blub"));

		// when
		List<Forename> forenameDuplicates;
		forenameDuplicates = checker.findDuplicates(forenameList);

		// then
		assertTrue(forenameDuplicates.size() == 2);
		assertTrue(forenameDuplicates.contains(new Forename("Karsten")));
		assertTrue(forenameDuplicates.contains(new Forename("Hans")));

	}

	@Test
	public void testUniqueKomplex() {
		// given
		List<Forename> forenameList = new ArrayList<Forename>();
		forenameList.add(new Forename("Karsten"));
		forenameList.add(new Forename("Andree"));
		forenameList.add(new Forename("Hans"));
		forenameList.add(new Forename("Franz"));
		forenameList.add(new Forename("Thomas"));
		forenameList.add(new Forename("Phillip"));
		forenameList.add(new Forename("Bla"));
		forenameList.add(new Forename("Blub"));

		// when
		List<Forename> forenameDuplicates;
		forenameDuplicates = checker.findDuplicates(forenameList);

		// then
		assertTrue(forenameDuplicates.size() == 0);

	}

	@Test
	public void testMinimumSimilarityNotZeroOrEqual() {
		Forename forename1 = new Forename("Karsten");
		Forename forename2 = new Forename("Carsten");

		boolean isDuplicate = checker.isDuplicate(forename1, forename2,
				Similarity.FULL_SIMILARITY);
		assertFalse(isDuplicate);

		boolean isDuplicate2 = checker.isDuplicate(forename1, forename2,
				Similarity.ZERO_SIMILARITY);
		assertTrue(isDuplicate2);
	}
}
