import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class InputTextParserTest {

    private InputTextParser parser;

    @Before
    public void setup()
        throws Exception {
        parser = new InputTextParser();
    }

    @Test
    public void should_parse_numbers_with_static_delimiter()
        throws Exception {
        Integer[] numbers = parser.parseNumbers( "10,20,30" );
        assertThat( Arrays.asList( numbers ), hasItems( 10, 20, 30 ) );
    }

    @Test
    public void should_cope_with_multiple_delimiters()
        throws Exception {
        Integer[] numbers = parser.parseNumbers( "1\n2,3" );
        assertThat( Arrays.asList( numbers ), hasItems( 1, 2, 3 ) );
    }

    @Test
    public void should_cope_with_multiple_chosen_delimiters()
        throws Exception {
        Integer[] numbers = parser.parseNumbers( "//\n\n1\n4" );
        assertThat( Arrays.asList( numbers ), hasItems( 1, 4 ) );

        numbers = parser.parseNumbers( "//:\n1:4" );
        assertThat( Arrays.asList( numbers ), hasItems( 1, 4 ) );
    }
}
