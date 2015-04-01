public class StringCalculator {

	public int add(String inputText) {
		CalculatorInput arguments = new CalculatorInput(inputText);
		return add(arguments);
	}
	
	private int add(CalculatorInput input) {

		int[] arguments = input.getCalculatorArguments();
		
		final InputValidator validator = new InputValidator();
		validator.abortIfNegativeNumbersAreContained(arguments);

		int sum = 0;
		for (int argument : arguments) {
			sum += argument;
		}
		return sum;
	}
	
}
