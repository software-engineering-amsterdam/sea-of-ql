package org.uva.sea.ql.parsers.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.core.dom.operators.arithmetic.Div;
import org.uva.sea.ql.core.dom.operators.arithmetic.Mul;
import org.uva.sea.ql.core.dom.operators.conditional.*;
import org.uva.sea.ql.parsers.MulExprParser;
import org.uva.sea.ql.parsers.ParserBaseForExpressions;
import org.uva.sea.ql.parsers.exceptions.ParseException;

public class MulExprParserTests {

	private ParserBaseForExpressions parser;
	
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
	
	@Test
	public void does_returnDivExpression_when_divideSignUsedBetweenTwoIdentifiers() throws ParseException {
		assertEquals(Div.class, parser.parse("a / b").getClass());		
	}
}
