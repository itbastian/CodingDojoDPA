public class CalculatorInput {

	private static final String DELIMITER_PREFIX = "//";
	private static final int DELIMITER_LENGTH = 1;
	private static final String DELIMITER_SPLITTER = "\n";

	
	private int[] parsedNumbers = null;
	
	public CalculatorInput(String textToParse) {
		parsedNumbers = parseNumbers(textToParse);
	}
	
	public int[] getCalculatorArguments() {
		return this.parsedNumbers;
	}
	
	private int[] parseNumbers(String inputText) {
		if (inputText.isEmpty()){
			return new int[]{0};
		}
		String stringDelimiter = "[,\n]";
		if (inputText.startsWith(DELIMITER_PREFIX)) {
			char delimiter = extractDelimiter(inputText);
			inputText = extractNumbersPart(inputText);
			stringDelimiter = delimiter + "";
		}
		int[] numbersAsInts = convertTextToNumbers(inputText, stringDelimiter);
		return numbersAsInts;
	}

	private String extractNumbersPart(String inputText) {
		return inputText.substring(DELIMITER_PREFIX.length()
				+ DELIMITER_LENGTH + DELIMITER_SPLITTER.length());
	}

	private char extractDelimiter(String inputText) {
		return inputText.charAt(DELIMITER_PREFIX.length());
	}
	
	private int[] convertTextToNumbers(String numbers, String stringDelimiter) {
		String[] split = numbers.split(stringDelimiter);
		int[] numbersAsInts = new int[split.length];
		for (int i = 0; i < split.length; i++) {
			numbersAsInts[i] = Integer.parseInt(split[i]);
		}
		return numbersAsInts;
	}
}
