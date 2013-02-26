package org.uva.sea.ql.parsers.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.operators.conditional.*;
import org.uva.sea.ql.parsers.AndExprParser;
import org.uva.sea.ql.parsers.ParserBaseForExpressions;
import org.uva.sea.ql.parsers.exceptions.ParseException;

public class AndExprParserTests {

	private ParserBaseForExpressions parser;
	
	@Before
    public void setUp() {
		this.parser = new AndExprParser();
    }
	
	@Test
	public void does_returnAndExpression_when_andSignUsedBetweenTwoIdentifiers() throws ParseException {
		assertEquals(And.class, parser.parse("a && b").getClass());		
	}
}
