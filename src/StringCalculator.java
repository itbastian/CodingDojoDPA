public class StringCalculator {

	public int add(String numbers) {
		int sum = 0;

		if (numbers.isEmpty()) {
			return sum;
		}

		String[] numbersAsStrings = numbers.split(",");
		for (String element : numbersAsStrings) {
			sum += Integer.valueOf(element);
		}
		return sum;
	}

}
