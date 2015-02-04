import com.sun.xml.internal.ws.util.StringUtils;

public class StringCalculator {

	private static final String DELIMITER_PREFIX = "//";
	private static final int DELIMITER_LENGTH = 1;
	private static final String DELIMITER_SPLITTER = "\n";

	public int add(String numbers) throws Exception {
		int sum = 0;

		if (numbers.isEmpty()) {
			return sum;
		}

		int[] numbersAsInts = parseNumbers(numbers);
		checkForNegativeNumbers(numbersAsInts);

		for (int element : numbersAsInts) {

			sum += element;
		}
		return sum;
	}

	private void checkForNegativeNumbers(int[] numbers) throws Exception {
		String negativeNumbers = null;
		for (int element : numbers) {
			if (element < 0) {
				if (negativeNumbers == null) {
					negativeNumbers = Integer.toString(element);
					continue;
				}
				negativeNumbers += "," + element;
			}
		}
		if (negativeNumbers != null) {
			throw new Exception(
					"Negative Zahlen sind nicht erlaubt. Folgende wurden gefunden: "
							+ negativeNumbers);
		}
		return;
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
