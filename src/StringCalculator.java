public class StringCalculator {

	private static final String DELIMITER_PREFIX = "//";
	private static final int DELIMITER_LENGTH = 1;
	private static final String DELIMITER_SPLITTER = "\n";

	public int add(String numbers) {
		int sum = 0;

		if (numbers.isEmpty()) {
			return sum;
		}
		int[] numbersAsInts = parseNumbers(numbers);

		for (int element : numbersAsInts) {
			sum += element;
		}
		return sum;
	}

	private int[] parseNumbers(String numbers) {
		String stringDelimiter = "[,\n]";
		if (numbers.startsWith(DELIMITER_PREFIX)) {
			char delimiter = numbers.charAt(DELIMITER_PREFIX.length());
			numbers = numbers.substring(DELIMITER_PREFIX.length()
					+ DELIMITER_LENGTH + DELIMITER_SPLITTER.length());
			stringDelimiter = delimiter + "";
		}
		int[] numbersAsInts = convertStringArrayToIntArray(numbers
				.split(stringDelimiter));
		return numbersAsInts;
	}

	private int[] convertStringArrayToIntArray(String[] numbers) {
		int[] numberAsInts = new int[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			numberAsInts[i] = Integer.parseInt(numbers[i]);
		}
		return numberAsInts;
	}

}
