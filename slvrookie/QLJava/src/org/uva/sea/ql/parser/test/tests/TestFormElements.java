package org.uva.sea.ql.parser.test.tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.uva.sea.ql.ast.CompQuestion;
import org.uva.sea.ql.ast.IfBody;
import org.uva.sea.ql.ast.Question;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.test.IParse;
import org.uva.sea.ql.parser.test.ParseError;



public class TestFormElements {
	
	final private IParse parser = new ANTLRParser();
	
	@Test
	public void testQuestion() throws ParseError {
		assertEquals(Question.class, parser.parseFormElement("dvdssd: \"fdhrdhfrrr\" int").getClass());
	}
	
	@Test
	public void testCompQuestion() throws ParseError {
		assertEquals(CompQuestion.class, parser.parseFormElement("dvdssd: \"fdhrdhfrrr\" int(432-4)").getClass());
	}
	
	@Test
	public void testIfBody() throws ParseError {
		assertEquals(IfBody.class, parser.parseFormElement("if (hasSoldHouse) { sellingPrice: \"Price the house was sold for:\" int }").getClass());
	}
}
