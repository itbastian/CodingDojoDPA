public class CalculatorInput {

	private static final String DELIMITER_PREFIX = "//";
	private static final int DELIMITER_LENGTH = 1;
	private static final String DELIMITER_SPLITTER = "\n";

	
	private int[] parsedNumbers;
	
	public CalculatorInput(String textToParse) {
		parsedNumbers = parseNumbers(textToParse);
	}
	
	public int[] getCalculatorArguments() {
		return parsedNumbers;
	}
	
	private int[] parseNumbers(final String inputText) {
		if (inputText.isEmpty()){
			return new int[]{0};
		}
		final String delimiter;
		final String numbersAsString;
		if (inputText.startsWith(DELIMITER_PREFIX)) {
			delimiter = extractDelimiter(inputText);
			numbersAsString = extractNumbersPart(inputText);
		} else {
			delimiter = "[,\n]";
			numbersAsString = inputText;
		}
		int[] numbers = convertTextToNumbers(numbersAsString, delimiter);
		return numbers;
	}

	private String extractNumbersPart(String inputText) {
		return inputText.substring(DELIMITER_PREFIX.length()
				+ DELIMITER_LENGTH + DELIMITER_SPLITTER.length());
	}

	private String extractDelimiter(String inputText) {
		return inputText.charAt(DELIMITER_PREFIX.length()) + "";
	}
	
	private int[] convertTextToNumbers(String numbers, String stringDelimiter) {
		String[] splittedNumbers = numbers.split(stringDelimiter);
		int[] numbersAsInts = new int[splittedNumbers.length];
		for (int i = 0; i < splittedNumbers.length; i++) {
			numbersAsInts[i] = Integer.parseInt(splittedNumbers[i]);
		}
		return numbersAsInts;
	}
}
