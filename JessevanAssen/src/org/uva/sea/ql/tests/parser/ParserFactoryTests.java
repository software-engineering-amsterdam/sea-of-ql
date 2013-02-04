package org.uva.sea.ql.tests.parser;

import org.junit.Test;
import org.uva.sea.ql.parser.Parser;
import org.uva.sea.ql.parser.ParserFactory;
import org.uva.sea.ql.parser.antlr.ANTLRParser;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotSame;

public class ParserFactoryTests {

    @Test
    public void createParserIsCalled_returnsInstanceOfANTLRParser() {
        Parser parser = ParserFactory.createParser();
        assertEquals(ANTLRParser.class, ParserFactory.createParser().getClass());
    }

    @Test
    public void createParserIsCalled_returnsANewInstance() {
        assertNotSame(
                ParserFactory.createParser(),
                ParserFactory.createParser()
        );
    }

}
