

public class CalculatorInput {

	private static final String DELIMITER_PREFIX = "//";
	private static final int DELIMITER_LENGTH = 1;
	private static final String DELIMITER_SPLITTER = "\n";

	private static final String OPERATOR_ADD = "+";
	private static final String OPERATOR_MULTIPLY = "*";
	
	private int[] parsedNumbers;
	private Operation operator;
	
	public CalculatorInput(String textToParse) {
		parsedNumbers = parseInput(textToParse);
	}
	
	public int[] getCalculatorArguments() {
		return parsedNumbers;
	}
	
	public Operation getOperation() {
		return this.operator;
	}
	
	private int[] parseInput(final String inputText) {
		if (inputText.isEmpty()){
			return new int[]{0};
		}
		final String delimiter;
		final String remainingString;
		
		if (inputText.startsWith(DELIMITER_PREFIX)) {
			delimiter = extractDelimiter(inputText);
			remainingString = extractRemainingInputWithoutDelimiterLine(inputText);
		} else {
			delimiter = "[,\n]";
			remainingString = inputText;
		}
		
		this.operator = parseOperator(remainingString);
		String numbersString = extractRemainingInputWithoutOperator(remainingString);
		
		int[] numbers = convertTextToNumbers(numbersString, delimiter);
		return numbers;
	}
	
	private Operation parseOperator(String inputTextWithoutDelimiterLine) {
		if (inputTextWithoutDelimiterLine.startsWith(OPERATOR_ADD)) {
			return Operation.ADD;
		} else if (inputTextWithoutDelimiterLine.startsWith(OPERATOR_MULTIPLY)) { 
			return Operation.MULTIPLY;
		} else {
			return Operation.ADD;
		}
	}

	private String extractRemainingInputWithoutOperator(String inputTextWithoutDelimiterLine) {
		int lengthOperatorDelimiter = 1;
	
		if (inputTextWithoutDelimiterLine.startsWith(OPERATOR_ADD)) {
			return inputTextWithoutDelimiterLine.substring(OPERATOR_ADD.length() + lengthOperatorDelimiter);
		} else if (inputTextWithoutDelimiterLine.startsWith(OPERATOR_MULTIPLY)) { 
			return inputTextWithoutDelimiterLine.substring(OPERATOR_MULTIPLY.length() + lengthOperatorDelimiter);
		} else {
			return inputTextWithoutDelimiterLine;
		}
	}
	
	private String extractRemainingInputWithoutDelimiterLine(String inputText) {
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
