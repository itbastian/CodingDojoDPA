package de.postadress.dojo.duplicatecheck;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicateChecker {

	public Similarity checkForDuplicate(Forename forename1, Forename forename2) {
		Similarity similarityOfForenames = forename1.getSimilarityTo(forename2);
		return similarityOfForenames;
	}

	public static List<Forename> findDuplicates(List<Forename> forenameList) {
		// TODO Auto-generated method stub
		List<Forename> resultForenames = new ArrayList<Forename>();
		for (int i = 0; i < forenameList.size(); i++) {
			for (int y = i + 1; y < forenameList.size(); y++) {
				if (forenameList.get(i).getSimilarityTo(forenameList.get(y))
						.equals(Similarity.FULL_SIMILARITY)) {
					resultForenames.add(forenameList.get(i));
				}
			}
		}
		return resultForenames;
	}

	public static List<Forename> findDuplicatesAlternate(
			List<Forename> forenameList) {
		List<Forename> resultForenames = new ArrayList<Forename>();
		Set<Forename> uniqueNames = new HashSet<Forename>();
		// resultForenames = forenameList.stream().filter(element ->
		// !uniqueNames.add(element));
		for (Forename forename : forenameList) {
			if (!uniqueNames.add(forename)) {
				resultForenames.add(forename);
			}
		}
		return resultForenames;
	}
}
