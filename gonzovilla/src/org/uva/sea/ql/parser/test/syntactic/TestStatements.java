package org.uva.sea.ql.parser.test.syntactic;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.stat.ComputedQuestion;
import org.uva.sea.ql.ast.stat.IfStatement;
import org.uva.sea.ql.ast.stat.Question;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.test.IParse;
import org.uva.sea.ql.parser.test.ParseError;

public class TestStatements {

	private IParse parser;

	public TestStatements() {
		parser = new ANTLRParser();
	}
	
	@Test
	public void testQuestion() throws ParseError {
		assertEquals(parser.parseStatements("hasSoldHouse: \"Did you sell a house in 2010?\" [Bool]").getClass(), Question.class);
	}
	
	@Test
	public void testComputedQuestion() throws ParseError {
		assertEquals(parser.parseStatements("valueResidue: \"Value residue:\" (sellingPrice - privateDebt) [Int]").getClass(), ComputedQuestion.class);
	}
	
	@Test
	public void testIfStatement() throws ParseError {
		assertEquals(parser.parseStatements("if (hasSoldHouse) then { " +
				"hasSoldHouse: \"Did you sell a house in 2010?\" [Bool] } " +
				"else " +
				"{ hasSoldHouse: \"Did you sell a house in 2010?\" [Bool] " +
				"valueResidue: \"Value residue:\" (sellingPrice - privateDebt) [Int] } endif"
				).getClass(), IfStatement.class);
	}
	
}
