public class InputTextParser {

    private static final String DELIMITER_PREFIX = "//";

    private static final int DELIMITER_LENGTH = 1;

    private static final String DELIMITER_SPLITTER = "\n";

    public Integer[] parseNumbers( String input ) {
        String stringDelimiter = "[,\n]";
        if ( input.startsWith( DELIMITER_PREFIX ) ) {
            char delimiter = input.charAt( DELIMITER_PREFIX.length() );
            input = input.substring( DELIMITER_PREFIX.length()
                + DELIMITER_LENGTH + DELIMITER_SPLITTER.length() );
            stringDelimiter = delimiter + "";
        }

        return stringToNumbers( input, stringDelimiter );
    }

    private Integer[] stringToNumbers( String input, String stringDelimiter ) {
        String[] tokens = input.split( stringDelimiter );
        Integer[] numbers = new Integer[tokens.length];
        for ( int i = 0; i < tokens.length; i++ ) {
            numbers[i] = Integer.parseInt( tokens[i] );
        }

        return numbers;
    }

}
