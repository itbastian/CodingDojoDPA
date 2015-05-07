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
		
		if (arguments.length == 0) {
			return 0;
		}
		
		final InputValidator validator = new InputValidator();
		validator.abortIfNegativeNumbersAreContained(arguments);

		int intermediateResult = arguments[0];
		for (int i = 1; i< arguments.length; i++) {
			switch (operation) {
			case ADD:
				intermediateResult += arguments[i];
				break;
				
			case MULTIPLY:
				intermediateResult *= arguments[i];
				break;

			default:
				break;
			}
		}
		return intermediateResult;
	}
	
}
