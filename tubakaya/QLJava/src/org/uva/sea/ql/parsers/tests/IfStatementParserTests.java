package org.uva.sea.ql.parsers.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.core.dom.statements.ComputedValue;
import org.uva.sea.ql.core.dom.statements.IfStatement;
import org.uva.sea.ql.core.dom.statements.Question;
import org.uva.sea.ql.parsers.IfStatementParser;
import org.uva.sea.ql.parsers.ParserBaseForStatements;
import org.uva.sea.ql.parsers.exceptions.ParseException;

public class IfStatementParserTests {

	private ParserBaseForStatements parser;
	
	@Before
    public void setUp() {
		this.parser = new IfStatementParser();
    }
	
	@Test
	public void does_returnIfStatement_when_thereIsOneStatementInsideIfm() throws ParseException {
		
		String text="if (true) { hasSoldHouse: \"Did you sell a house in 2010?\" boolean }";
		assertEquals(IfStatement.class, parser.parse(text).getClass());		
	}
	
	@Test
	public void does_createIfStatementWithOneQuestionAndOneComputedValue_when_thereIsAQuestionAndAComputedValueInsideIf() throws ParseException {
		
		String text="if (true) { hasSoldHouse: \"Did you sell a house in 2010?\" boolean valueResidue: \"Value residue:\" integer(5-3)}";
		IfStatement actual=(IfStatement)parser.parse(text);
		assertEquals(2, actual.getStatements().size());		
		assertEquals(Question.class, actual.getStatements().get(0).getClass());	
		assertEquals(ComputedValue.class, actual.getStatements().get(1).getClass());	
	}
}
