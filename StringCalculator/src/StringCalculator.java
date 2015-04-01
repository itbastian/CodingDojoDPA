public class StringCalculator {
	
	enum Operation {
		ADD,
		MULTIPLY;
	}

	public int add(String inputText) {
		return calculate(inputText);
	}
	
	public int calculate(String inputText) {
		CalculatorInput arguments = new CalculatorInput(inputText);
		return calculate(arguments);
	}
	
	private int add(int value1, int value2) {
		return value1 + value2;
	}

	private int calculate(CalculatorInput input) {
		int[] arguments = input.getCalculatorArguments();
		Operation operation = Operation.ADD;
		
		final InputValidator validator = new InputValidator();
		validator.abortIfNegativeNumbersAreContained(arguments);

		int sum = 0;
		for (int argument : arguments) {
			switch (operation) {
			case ADD:
				sum = add(sum, argument);
				break;

			default:
				break;
			}
		}
		return sum;
	}
	
}
