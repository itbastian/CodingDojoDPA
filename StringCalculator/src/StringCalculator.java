
public class StringCalculator {

	public int add(String inputText) throws Exception {
		CalculatorInput arguments = new CalculatorInput(inputText);
		return add(arguments);
	}
	
	private int add(CalculatorInput input) {

		int[] arguments = input.getCalculatorArguments();

		checkForNegativeNumbers(arguments);

		int sum = 0;
		for (int argument : arguments) {
			sum += argument;
		}
		return sum;
	}

	private void checkForNegativeNumbers(int[] numbers) {
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
			throw new IllegalArgumentException(
					"Negative Zahlen sind nicht erlaubt. Folgende wurden gefunden: "
							+ negativeNumbers);
		}
		return;
	}
	
}
