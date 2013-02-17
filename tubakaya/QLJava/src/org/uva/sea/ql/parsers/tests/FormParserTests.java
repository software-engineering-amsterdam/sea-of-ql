package org.uva.sea.ql.parsers.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.core.dom.statements.ComputedValue;
import org.uva.sea.ql.core.dom.statements.Form;
import org.uva.sea.ql.core.dom.statements.IfStatement;
import org.uva.sea.ql.core.dom.statements.Question;
import org.uva.sea.ql.parsers.FormParser;
import org.uva.sea.ql.parsers.ParserBaseForStatements;
import org.uva.sea.ql.parsers.exceptions.ParseException;

public class FormParserTests {

	private ParserBaseForStatements parser;
	
	@Before
    public void setUp() {
		this.parser = new FormParser();
    }
	
	@Test
	public void does_returnFormExpression_when_thereIsOneStatementInsideForm() throws ParseException {
		
		String text="form Box1HouseOwning { hasSoldHouse: \"Did you sell a house in 2010?\" boolean }";
		assertEquals(Form.class, parser.parse(text).getClass());		
	}
	
	@Test
	public void does_receiveTwoStatements_when_thereAreTwoStatementsInsideForm() throws ParseException {
		
		String text="form Box1HouseOwning { hasSoldHouse: \"Did you sell a house in 2010?\" boolean hasBoughtHouse: \"Did you by a house in 2010?\" boolean}";
		Form actual=(Form)parser.parse(text);
		assertEquals(2, actual.statements.size());		
	}
	
	@Test
	public void does_createEmptyForm_when_thereAreNoStatementsInsideForm() throws ParseException {
		
		String text="form Box1HouseOwning {}";
		Form actual=(Form)parser.parse(text);
		assertEquals(0, actual.statements.size());		
	}
	
	@Test
	public void does_createFormWithOneQuestionAndOneComputedValue_when_thereIsAQuestionAndAComputedValueInsideForm() throws ParseException {
		
		String text="form Box1HouseOwning {hasSoldHouse: \"Did you sell a house in 2010?\" boolean valueResidue: \"Value residue:\" integer(2)}";
		Form actual=(Form)parser.parse(text);
		assertEquals(2, actual.statements.size());		
		assertEquals(Question.class, actual.statements.get(0).getClass());	
		assertEquals(ComputedValue.class, actual.statements.get(1).getClass());	
	}
	
	@Test
	public void does_createFormWithOneIfStatement_when_thereIsAnIfStatementInsideForm() throws ParseException {
		
		String text="form Box1HouseOwning {if (true) { hasSoldHouse: \"Did you sell a house in 2010?\" boolean valueResidue: \"Value residue:\" integer(5-3)}}";
		Form actual=(Form)parser.parse(text);
		assertEquals(1, actual.statements.size());		
		assertEquals(IfStatement.class, actual.statements.get(0).getClass());
	}
	
	@Test
	public void does_createFormWithOneIfStatementAndOneQuestion_when_entireFormStringIsGiven() throws ParseException {
		
		String text="form Box1HouseOwning {" +
				"hasSoldHouse: \"Did you sell a house in 2010?\" boolean" +
				" if (hasSoldHouse) { " +
				"valueResidue: \"Value residue:\" integer(5-3)" +
				"}" +
				"}";
		Form actual=(Form)parser.parse(text);
		assertEquals(2, actual.statements.size());		
		assertEquals(Question.class, actual.statements.get(0).getClass());
		assertEquals(IfStatement.class, actual.statements.get(1).getClass());
	}
}
