package org.uva.sea.ql.tests.parser.parserTests;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.uva.sea.ql.parser.ParseError;

public class FailToParse extends ParserTests {

    @Test(expected = ParseError.class)
    public void TriesToParseUnknownFormat_ExceptionIsThrown() throws ParseError {
        final String toParse = "KxizKAWZ9eBPjHJwLlQpHTQHbLB2bsVzRvPV6q4jfwM4no8ZD9eMbHDryfmoG2gmh4qk3lBAjmQZIMf8MikaOx5nwa0rd7aJQHw";
        parser.parse(toParse);
    }

}
