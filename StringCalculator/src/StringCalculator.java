import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class StringCalculator {

	public int add(String inputText) throws Exception {
		CalculatorInput arguments = new CalculatorInput(inputText);
		return add(arguments);
	}
	
	private int add(CalculatorInput input) {

		int[] arguments = input.getCalculatorArguments();

		abortIfNegativeNumbersAreContained(arguments);

		int sum = 0;
		for (int argument : arguments) {
			sum += argument;
		}
		return sum;
	}

	private void abortIfNegativeNumbersAreContained(int[] numbers) {
		List<Integer> negativeNumbers = new ArrayList<Integer>();
		for (int element : numbers) {
			if (element < 0) {
				negativeNumbers.add(element);
			}
		}
		
		if (!negativeNumbers.isEmpty()) {
			throw new IllegalArgumentException(
					"Negative Zahlen sind nicht erlaubt. Folgende wurden gefunden: "
							+ join(negativeNumbers));
		}
		return;
	}

	private String join(List<Integer> negativeNumbers) {
		Iterator<Integer> iterator = negativeNumbers.iterator();
		StringBuilder str = new StringBuilder();
		
		while(iterator.hasNext()) {
			str.append(iterator.next());
			if(iterator.hasNext()) {
				str.append(",");
			}
		}
		
		return str.toString();
	}
	
}
