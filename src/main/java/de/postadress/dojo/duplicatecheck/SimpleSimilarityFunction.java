package de.postadress.dojo.duplicatecheck;

import org.apache.commons.lang.StringUtils;

public class SimpleSimilarityFunction implements SimilarityFunctionI {

	/* (non-Javadoc)
	 * @see de.postadress.dojo.duplicatecheck.SimilarityFunctionI#calculateSimilarity(de.postadress.dojo.duplicatecheck.Forename, de.postadress.dojo.duplicatecheck.Forename)
	 */
	@Override
	public Similarity calculateSimilarity(Forename first, Forename second) {
		if (StringUtils.equals(first.getForenameAsString(),
				second.getForenameAsString())) {
			return Similarity.FULL_SIMILARITY;
		}
		return Similarity.ZERO_SIMILARITY;
	}
}
