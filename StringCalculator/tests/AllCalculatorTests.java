import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AllCalculatorTests {

	private StringCalculator calculator;

	@Before
	public void setup() {
		calculator = new StringCalculator();
	}

	@Test
	public void add_two_numbers() throws Exception {
		int result = calculator.add("1,65");
		assertEquals(66, result);
	}

	@Test
	public void add_one_number() throws Exception {
		int result = calculator.add("1");
		assertEquals(1, result);
	}

	@Test
	public void return_zero_for_no_number() throws Exception {
		int result = calculator.add("");
		assertEquals(0, result);
	}

	@Test
	public void add_multiple_numbers() throws Exception {
		int resultThreeNumbers = calculator.add("1,2,3");
		int resultFourNumbers = calculator.add("1,2,3,4");

		assertEquals(6, resultThreeNumbers);
		assertEquals(10, resultFourNumbers);
	}
	
	@Test
	public void add_with_explicit_operator() throws Exception {
		int result = calculator.calculate("+\n1,2,3");

		assertEquals(6, result);
	}
	
	@Test
	public void multiply_with_explicit_operator() throws Exception {
		int result = calculator.calculate("*\n5,2,3");

		assertEquals(30, result);
	}
	
	@Test
	public void parse_operator() {
		CalculatorInput input = new CalculatorInput("*\n5,3");

		assertEquals(StringCalculator.Operation.MULTIPLY, input.getOperation());
		
		
		input = new CalculatorInput("+\n5,3");

		assertEquals(StringCalculator.Operation.ADD, input.getOperation());
	}

	@Test
	public void cope_with_multiple_delimiters() throws Exception {
		int resultThreeNumbers = calculator.add("1\n2,3");

		assertEquals(6, resultThreeNumbers);
	}

	@Test
	public void cope_with_multiple_chosen_delimiters() throws Exception {
		int resultThreeNumbers = calculator.add("//\n\n1\n4");
		assertEquals(5, resultThreeNumbers);

		int resultThreeNumbersOtherDelimiter = calculator.add("//:\n1:4");
		assertEquals(5, resultThreeNumbersOtherDelimiter);

	}


	@Test
	public void throw_exception_when_negative_number_included() {
		String input = "//:\n1:8:-3";
		try {
			calculator.add(input);
			fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(),
					"Negative Zahlen sind nicht erlaubt. Folgende wurden gefunden: -3");
		}
	}

}
