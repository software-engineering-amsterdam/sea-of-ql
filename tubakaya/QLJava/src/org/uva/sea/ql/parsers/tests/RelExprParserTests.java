package org.uva.sea.ql.parsers.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.core.dom.operators.conditional.*;
import org.uva.sea.ql.core.dom.operators.relational.Eq;
import org.uva.sea.ql.core.dom.operators.relational.GEq;
import org.uva.sea.ql.core.dom.operators.relational.GT;
import org.uva.sea.ql.core.dom.operators.relational.LEq;
import org.uva.sea.ql.core.dom.operators.relational.LT;
import org.uva.sea.ql.core.dom.operators.relational.NEq;
import org.uva.sea.ql.parsers.RelExprParser;
import org.uva.sea.ql.parsers.ParserBaseForExpressions;
import org.uva.sea.ql.parsers.exceptions.ParseException;

public class RelExprParserTests {

	private ParserBaseForExpressions parser;
	
	@Before
    public void setUp() {
		this.parser = new RelExprParser();
    }
	
	@Test
	public void does_returnLTExpression_when_lessThanSignUsedBetweenTwoIdentifiers() throws ParseException {
		assertEquals(LT.class, parser.parse("a < b").getClass());		
	}
	
	@Test
	public void does_returnLTExpression_when_lessThanSignUsedBetweenAnIdentifierAndACalculation() throws ParseException {
		assertEquals(LT.class, parser.parse("a < b + c").getClass());		
	}
	
	@Test
	public void does_returnLTExpression_when_lessThanSignUsedBetweenAnIdentifierAndACalculationWithinParanthesis() throws ParseException {
		assertEquals(LT.class, parser.parse("a < (b * c)").getClass());		
	}
	
	@Test
	public void does_returnLTExpression_when_lessThanSignUsedBetweenACalculationWithinParanthesisAndAnIdentifier() throws ParseException {
		assertEquals(LT.class, parser.parse("(a * b) < c").getClass());		
	}	
	
	@Test
	public void does_returnLEqExpression_when_lessThanAndEqualsToSignUsedBetweenTwoIdentifiers() throws ParseException {
		assertEquals(LEq.class, parser.parse("a <= b").getClass());		
	}
	
	@Test
	public void does_returnGTExpression_when_greaterThanSignUsedBetweenTwoIdentifiers() throws ParseException {
		assertEquals(GT.class, parser.parse("a > b").getClass());		
	}
	
	@Test
	public void does_returnGTExpression_when_greaterThanSignUsedBetweenAnIdentifierAndACalculation() throws ParseException {
		assertEquals(GT.class, parser.parse("a + b > c").getClass());		
	}
	
	@Test
	public void does_returnGTExpression_when_greaterThanSignUsedBetweenACalculationAndAnIdentifier() throws ParseException {
		assertEquals(GT.class, parser.parse("a > b + c").getClass());		
	}
	
	@Test
	public void does_returnGEqExpression_when_greaterThanAndEqualsToSignUsedBetweenTwoIdentifiers() throws ParseException {
		assertEquals(GEq.class, parser.parse("a >= b").getClass());		
	}
	
	@Test
	public void does_returnEqExpression_when_equalsToSignUsedBetweenTwoIdentifiers() throws ParseException {
		assertEquals(Eq.class, parser.parse("a == b").getClass());		
	}
	
	@Test
	public void does_returnNEqExpression_when_notEqualsToSignUsedBetweenTwoIdentifiers() throws ParseException {
		assertEquals(NEq.class, parser.parse("a != b").getClass());		
	}
}
