package eu.karuza.ql.parser;

import org.junit.Test;

import eu.karuza.ql.error.ParseError;
import eu.karuza.ql.parser.IParse;
import eu.karuza.ql.parser.antlr.ANTLRParser;

public class TestSyntaxException {

	private IParse parser = new ANTLRParser();

	@Test(expected = ParseError.class)
	public void testParseExceptionThrown() throws ParseError {
		parser.parseNode("form form1 { question1 \" some text label\" boolean }");
	}

}
