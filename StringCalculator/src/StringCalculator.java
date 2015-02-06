import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StringCalculator {

    private InputTextParser parser;

    public StringCalculator() {
        parser = new InputTextParser();
    }

    StringCalculator( InputTextParser parser ) {
        this.parser = parser;
    }

    public int add( String inputText )
        throws Exception {
        int sum = 0;

        if ( inputText.isEmpty() ) {
            return sum;
        }

        Integer[] numbers = parser.parseNumbers( inputText );
        checkForNegativeNumbers( numbers );

        for ( int element : numbers ) {

            sum += element;
        }
        return sum;
    }

    private void checkForNegativeNumbers( Integer[] numbers )
        throws Exception {
        List<Integer> negativeNumbers = new ArrayList<Integer>();
        for ( int element : numbers ) {
            if ( element < 0 ) {
                negativeNumbers.add( element );
            }
        }

        if ( !negativeNumbers.isEmpty() ) {
            throw new Exception(
                "Negative Zahlen sind nicht erlaubt. Folgende wurden gefunden: "
                    + join( negativeNumbers ) );
        }
    }

    private String join( List<Integer> negativeNumbers ) {
        String joinedInts = "";
        Iterator<Integer> iterator = negativeNumbers.iterator();
        while ( iterator.hasNext() ) {
            joinedInts += iterator.next();
            if ( iterator.hasNext() ) {
                joinedInts += ",";
            }
        }

        return joinedInts;
    }

}
