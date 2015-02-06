import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StringCalculatorTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private StringCalculator calculator;

    @Before
    public void setup() {
        calculator = new StringCalculator();
    }

    @Test
    public void should_build_sum_of_two_numbers()
        throws Exception {
        int result = calculator.add( "1,65" );
        assertEquals( 66, result );
    }

    @Test
    public void should_build_sum_of_one_number()
        throws Exception {
        int result = calculator.add( "1" );
        assertEquals( 1, result );
    }

    @Test
    public void should_return_zero_for_no_number()
        throws Exception {
        int result = calculator.add( "" );
        assertEquals( 0, result );
    }

    @Test
    public void should_build_sum_of_multiple_numbers()
        throws Exception {
        int resultThreeNumbers = calculator.add( "1,2,3" );
        int resultFourNumbers = calculator.add( "1,2,3,4" );

        assertEquals( 6, resultThreeNumbers );
        assertEquals( 10, resultFourNumbers );
    }

    @Test( expected = Exception.class )
    public void should_throw_exception_when_negative_number_included()
        throws Exception {
        String input = "1,8,-3";
        calculator.add( input );
    }

    @Test
    public void should_throw_exception_when_negative_number_included2()
        throws Exception {
        String input = "1,8,-3";

        expectedException.expect( Exception.class );
        expectedException.expectMessage( "Negative Zahlen sind nicht erlaubt. Folgende wurden gefunden: -3" );
        calculator.add( input );
    }
}
