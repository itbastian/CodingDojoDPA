package de.postadress.dojo.duplicatecheck;

public interface SimilarityFunctionI {

	public abstract Similarity calculateSimilarity(Forename first,
			Forename second);

}