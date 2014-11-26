package de.postadress.dojo.duplicatecheck;

public class DuplicateChecker {

	public Similarity checkForDuplicate(Forename forename1, Forename forename2) {
		Similarity similarityOfForenames = forename1.getSimilarityTo(forename2);
		return similarityOfForenames;
	}

}
