package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.uva.sea.ql.ast.statements.*;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.test.IParse;
import org.uva.sea.ql.parser.test.ParseError;

public class TestStatements {

	private IParse parser;
	
	public TestStatements() {
		this.parser = new ANTLRParser();
	}

	
	@Test
	public void testStatements() throws ParseError {
	 	assertEquals(parser.parseStatement("hasSoldHouse: \"Did you sell a house in 2010?\" boolean").getClass(),
	 			Question.class);
	 	
	 	assertEquals(parser.parseStatement("privateDebt: \"Private debts for the sold house:\" int").getClass(),
	 			Question.class);
	 	
	 	assertEquals(parser.parseStatement("privateDebt: \"Private debts for the sold house:\" int " +
	 			"(sellingPrice * privateDebt)").getClass(),
	 			ComputedQuestion.class);
	 	
	 	assertEquals(parser.parseStatement("if (a>b) { privateDebt: \"Private debts for the sold house:\" int}").getClass(),
	 			ifStatement.class);
	 	
	 	assertEquals(parser.parseStatement("if (a>b) { privateDebt: \"Private debts for the sold house:\" int}" +
	 			"else {hasSoldHouse: \"Did you sell a house in 2010?\" boolean} ").getClass(),
	 			ifElseStatement.class);
	}
}
