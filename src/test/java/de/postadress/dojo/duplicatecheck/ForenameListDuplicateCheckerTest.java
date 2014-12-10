package de.postadress.dojo.duplicatecheck;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import jdk.nashorn.internal.ir.ForNode;

import org.junit.Test;

public class ForenameListDuplicateCheckerTest {

	@Test
	public void testDuplicate() {
		// given
		List<Forename> forenameList = new ArrayList<Forename>();
		forenameList.add(new Forename("Karsten"));
		forenameList.add(new Forename("Karsten"));

		// when
		List<Forename> forenameDuplicates;
		forenameDuplicates = DuplicateChecker.findDuplicates(forenameList);

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
		forenameDuplicates = DuplicateChecker
				.findDuplicatesAlternate(forenameList);

		// then
		assertTrue(forenameDuplicates.size() == 2);
		assertTrue(forenameDuplicates.contains(new Forename("Karsten")));
		assertTrue(forenameDuplicates.contains(new Forename("Hans")));

	}

}
