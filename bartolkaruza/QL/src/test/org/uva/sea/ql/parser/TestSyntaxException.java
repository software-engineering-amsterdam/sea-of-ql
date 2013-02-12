package org.uva.sea.ql.parser;

import org.junit.Test;
import org.uva.sea.ql.error.ParseError;
import org.uva.sea.ql.parser.antlr.ANTLRParser;

public class TestSyntaxException {

	private IParse parser = new ANTLRParser();

	@Test(expected = ParseError.class)
	public void testParseExceptionThrown() throws ParseError {
		parser.parseNode("form form1 { question1 \" some text label\" boolean }");
	}

}
