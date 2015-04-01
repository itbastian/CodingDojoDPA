import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class InputValidator {

	public void abortIfNegativeNumbersAreContained(int[] numbers) {
		List<Integer> negativeNumbers = new ArrayList<Integer>();
		for (int element : numbers) {
			if (element < 0) {
				negativeNumbers.add(element);
			}
		}		
		assertNegativeNumbersAreNotContained(negativeNumbers);
	}

	private void assertNegativeNumbersAreNotContained(List<Integer> negativeNumbers) {
		if (!negativeNumbers.isEmpty()) {
			throw new IllegalArgumentException(
					"Negative Zahlen sind nicht erlaubt. Folgende wurden gefunden: "
							+ join(negativeNumbers));
		}
	}

	private String join(List<Integer> negativeNumbers) {
		Iterator<Integer> iterator = negativeNumbers.iterator();
		StringBuilder str = new StringBuilder();
		
		while(iterator.hasNext()) {
			str.append(iterator.next());
			if(iterator.hasNext()) {
				str.append(", ");
			}
		}
		
		return str.toString();
	}
}
