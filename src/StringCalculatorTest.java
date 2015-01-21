import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {

	private StringCalculator calculator;

	@Before
	public void setup() {
		calculator = new StringCalculator();
	}

	@Test
	public void should_build_sum_of_two_numbers() throws Exception {
		int result = calculator.add("1,65");
		assertEquals(66, result);
	}

	@Test
	public void should_build_sum_of_one_number() throws Exception {
		int result = calculator.add("1");
		assertEquals(1, result);
	}

	@Test
	public void should_return_zero_for_no_number() throws Exception {
		int result = calculator.add("");
		assertEquals(0, result);
	}

	@Test
	public void should_build_sum_of_multiple_numbers() throws Exception {
		int resultThreeNumbers = calculator.add("1,2,3");
		int resultFourNumbers = calculator.add("1,2,3,4");

		assertEquals(6, resultThreeNumbers);
		assertEquals(10, resultFourNumbers);
	}
}
