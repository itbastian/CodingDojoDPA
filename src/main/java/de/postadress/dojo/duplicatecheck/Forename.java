package de.postadress.dojo.duplicatecheck;

import org.apache.commons.lang.StringUtils;

public class Forename {

	private final String value;

	public Forename(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}

	boolean isDuplicateOf(Forename objectToCompare) {
		return StringUtils.equals(value, objectToCompare.value);
	}

	public Similarity getSimilarityTo(Forename forename2) {
		if (isDuplicateOf(forename2) == true) {
			return Similarity.FULL_SIMILARITY;
		}
		return Similarity.ZERO_SIMILARITY;
	}

}
