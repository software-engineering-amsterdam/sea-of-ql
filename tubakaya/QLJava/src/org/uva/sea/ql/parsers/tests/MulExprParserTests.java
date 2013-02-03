package org.uva.sea.ql.parsers.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.operations.*;
import org.uva.sea.ql.parser.exceptions.ParseException;
import org.uva.sea.ql.parsers.MulExprParser;
import org.uva.sea.ql.parsers.ParserBase;

public class MulExprParserTests {

	private ParserBase parser;
	
	@Before
    public void setUp() {
		this.parser = new MulExprParser();
    }
	
	@Test
	public void does_returnMulExpression_when_starSignUsedBetweenTwoIdentifiers() throws ParseException {
		assertEquals(Mul.class, parser.parse("a * b").getClass());		
	}
	
	@Test
	public void does_returnMulExpression_when_starSignUsedBetweenThreeIdentifiers() throws ParseException {
		assertEquals(Mul.class, parser.parse("a * b * c").getClass());		
	}
	
	@Test
	public void does_returnMulExpression_when_starSignUsedBetweenAnIdentifierAndAnotherCalculationWithinParanthesis() throws ParseException {
		assertEquals(Mul.class, parser.parse("a * (b * c)").getClass());		
	}
	
	@Test
	public void does_returnMulExpression_when_starSignUsedBetweenAMultiplicationWithinParanthesisAndAnIdentifier() throws ParseException {
		assertEquals(Mul.class, parser.parse("(a * b) * c").getClass());		
	}
	
	@Test
	public void does_returnMulExpression_when_starSignUsedBetweenTwoIdentifiersWithinParanthesis() throws ParseException {
		assertEquals(Mul.class, parser.parse("(a * b)").getClass());		
	}
	

	@Test
	public void does_returnMulExpression_when_starSignUsedBetweenAnAdditionWithinParanthesisAndAnIdentifier() throws ParseException {
		assertEquals(Mul.class, parser.parse("(a + b) * c").getClass());		
	}
	
	@Test
	public void does_returnMulExpression_when_starSignUsedBetweenAnIdentifierAndAnAdditionWithinParanthesis() throws ParseException {
		assertEquals(Mul.class, parser.parse("a * (b + c)").getClass());		
	}
}
