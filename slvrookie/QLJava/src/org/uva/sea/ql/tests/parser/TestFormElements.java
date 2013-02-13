package org.uva.sea.ql.tests.parser;

import static org.junit.Assert.*;
import org.junit.Test;
import org.uva.sea.ql.ast.formelements.CompQuestion;
import org.uva.sea.ql.ast.formelements.IfThen;
import org.uva.sea.ql.ast.formelements.IfThenElse;
import org.uva.sea.ql.ast.formelements.Question;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.antlr.IParse;
import org.uva.sea.ql.parser.antlr.ParseError;

public class TestFormElements {

	final private IParse parser = new ANTLRParser();

	@Test
	public void testQuestion() throws ParseError {
		assertEquals(Question.class, parser.parseFormElement("dvdssd: \"fdhrdhfrrr\" int").getClass());
	}

	@Test
	public void testCompQuestion() throws ParseError {
		assertEquals(CompQuestion.class, parser.parseFormElement("dvdssd: \"fdhrdhfrrr\" int(3-1)").getClass());
	}

	@Test
	public void testIfBody() throws ParseError {
		assertEquals(IfThen.class, parser.parseFormElement("if (hasSoldHouse) { sellingPrice: \"Price the house was sold for:\" int }").getClass());
	}
	
	@Test
	public void testIfElseBody() throws ParseError {
		assertEquals(IfThenElse.class, parser.parseFormElement("if (hasSoldHouse) { sellingPrice: \"Price the house was sold for:\" int } else{sellingPrice: \"Price the house was sold for:\" int} ").getClass());
	}

}
