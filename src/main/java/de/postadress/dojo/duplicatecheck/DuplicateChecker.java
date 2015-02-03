package de.postadress.dojo.duplicatecheck;

import java.util.ArrayList;
import java.util.List;

public class DuplicateChecker {

	private final SimilarityFunctionI function;

	public DuplicateChecker(SimilarityFunctionI function) {
		this.function = function;
	}

	public boolean isDuplicate(Forename forename1, Forename forename2,
			Similarity minimumSimilarity) {
		Similarity similarityOfForenames = function.calculateSimilarity(
				forename1, forename2);
		return similarityOfForenames.compareTo(minimumSimilarity) >= 0;
	}

	public List<Forename> findDuplicates(List<Forename> forenameList) {
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
}
