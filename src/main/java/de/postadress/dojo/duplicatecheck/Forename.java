package de.postadress.dojo.duplicatecheck;

import org.apache.commons.lang.StringUtils;

public class Forename {

	private final String value;

	public Forename(String forename) {
		this.value = forename;
	}

	public String getForenameAsString() {
		return value;
	}

	@Override
	public String toString() {
		return "Forename: " + value;
	}

	private boolean isDuplicateOf(Forename objectToCompare) {
		return StringUtils.equals(value, objectToCompare.value);
	}

	public Similarity getSimilarityTo(Forename forename2) {
		if (isDuplicateOf(forename2) == true) {
			return Similarity.FULL_SIMILARITY;
		}
		return Similarity.ZERO_SIMILARITY;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (value == null ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Forename other = (Forename) obj;
		if (value == null) {
			if (other.value != null) {
				return false;
			}
		} else if (!value.equals(other.value)) {
			return false;
		}
		return true;
	}

}
