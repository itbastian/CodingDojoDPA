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
        String negativeNumbers = null;
        for ( int element : numbers ) {
            if ( element < 0 ) {
                if ( negativeNumbers == null ) {
                    negativeNumbers = Integer.toString( element );
                    continue;
                }
                negativeNumbers += "," + element;
            }
        }
        if ( negativeNumbers != null ) {
            throw new Exception(
                "Negative Zahlen sind nicht erlaubt. Folgende wurden gefunden: "
                    + negativeNumbers );
        }
        return;
    }

}
