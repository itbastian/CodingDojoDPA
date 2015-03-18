public class CalculatorInput {

	private static final String DEFAULT_DELIMITER = "[,\n]";
	private static final String DELIMITER_PREFIX = "//";
	private static final int DELIMITER_LENGTH = 1;
	private static final String DELIMITER_SPLITTER = "\n";

	private int[] parsedNumbers;
	private String inputText;
	private String currentDelimiter;

	public CalculatorInput(String textToParse) {
		this.inputText = textToParse;
		parseDelimiter();
		parseNumbers();
	}

	private void parseDelimiter() {
		if (startsWithDelimiterPrefix()) {
			char delimiter = extractDelimiter(inputText);
			currentDelimiter = String.valueOf(delimiter);
		} else {
			currentDelimiter = DEFAULT_DELIMITER;
		}
	}

	public int[] getCalculatorArguments() {
		return this.parsedNumbers;
	}

	private void parseNumbers() {
		String numbersText = extractNumbersPart();
		if (numbersText.isEmpty()) {
			parsedNumbers = new int[] { 0 };
		} else {
			parsedNumbers = convertTextToNumbers(numbersText);
		}
	}

	private String extractNumbersPart() {
		if (startsWithDelimiterPrefix()) {
			return inputText.substring(DELIMITER_PREFIX.length() + DELIMITER_LENGTH
					+ DELIMITER_SPLITTER.length());
		}
		return inputText;
	}

	private boolean startsWithDelimiterPrefix() {
		return inputText.startsWith(DELIMITER_PREFIX);
	}

	private char extractDelimiter(String inputText) {
		return inputText.charAt(DELIMITER_PREFIX.length());
	}

	private int[] convertTextToNumbers(String numbersText) {
		String[] split = numbersText.split(currentDelimiter);
		int[] numbersAsInts = new int[split.length];
		for (int i = 0; i < split.length; i++) {
			numbersAsInts[i] = Integer.parseInt(split[i]);
		}
		return numbersAsInts;
	}
}
