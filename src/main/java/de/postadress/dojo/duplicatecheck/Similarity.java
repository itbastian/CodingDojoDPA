package de.postadress.dojo.duplicatecheck;

public class Similarity implements Comparable<Similarity> {
	public static final Similarity FULL_SIMILARITY = new Similarity(100);
	public static final Similarity ZERO_SIMILARITY = new Similarity(0);

	private final int similarityValue;

	public Similarity(int similarityValue) {
		this.similarityValue = similarityValue;
	}

	public int getSimilarityValue() {
		return similarityValue;
	}

	@Override
	public int compareTo(Similarity o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
