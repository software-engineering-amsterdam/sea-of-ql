package org.uva.sea.ql.parsers.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.operations.*;
import org.uva.sea.ql.parser.exceptions.ParseException;
import org.uva.sea.ql.parsers.UnExprParser;
import org.uva.sea.ql.parsers.ParserBase;

public class UnExprParserTests {

	private ParserBase parser;
	
	@Before
    public void setUp() {
		this.parser = new UnExprParser();
    }
	
	@Test
	public void does_returnPosExpression_when_plusSignUsedBeforeAnIdentifier() throws ParseException {
		assertEquals(Pos.class, parser.parse("+a").getClass());		
	}
	
	@Test
	public void does_returnPosExpression_when_plusSignUsedBeforeACalculationWithinParanthesis() throws ParseException {
		assertEquals(Pos.class, parser.parse("+( a * b)").getClass());		
	}
	
	@Test
	public void does_returnNegExpression_when_minusSignUsedBeforeAnIdentifier() throws ParseException {
		assertEquals(Neg.class, parser.parse("-a").getClass());		
	}
	
	@Test
	public void does_returnNegExpression_when_minusSignUsedBeforeACalculationWithinParanthesis() throws ParseException {
		assertEquals(Neg.class, parser.parse("- (a * b)").getClass());		
	}
	
	@Test
	public void does_returnNotExpression_when_exclamationMarkSignUsedBeforeAnIdentifier() throws ParseException {
		assertEquals(Not.class, parser.parse("!a").getClass());		
	}
	
	@Test
	public void does_returnNotExpression_when_exclamationMarkSignUsedBeforeACalculationWithinParanthesis() throws ParseException {
		assertEquals(Not.class, parser.parse("! ( a && b)").getClass());		
	}
}
