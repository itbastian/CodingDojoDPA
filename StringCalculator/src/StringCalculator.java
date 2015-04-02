public class StringCalculator {
	
	public int add(String inputText) {
		return calculate(inputText);
	}
	
	public int calculate(String inputText) {
		CalculatorInput arguments = new CalculatorInput(inputText);
		return calculate(arguments);
	}
	
	private int calculate(CalculatorInput input) {
		int[] arguments = input.getCalculatorArguments();
		Operation operation = input.getOperation();
		
		final InputValidator validator = new InputValidator();
		validator.abortIfNegativeNumbersAreContained(arguments);

		int sum = 0;
		for (int argument : arguments) {
			switch (operation) {
			case ADD:
				sum += argument;
				break;
				
			case MULTIPLY:
				sum *= argument;
				break;

			default:
				break;
			}
		}
		return sum;
	}
	
}
