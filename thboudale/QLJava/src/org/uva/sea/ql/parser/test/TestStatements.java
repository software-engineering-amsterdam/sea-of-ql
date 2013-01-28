package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.uva.sea.ql.ast.statements.*;
import org.uva.sea.ql.parser.antlr.ANTLRParser;

@RunWith(Parameterized.class)
public class TestStatements {

	private IParse parser;

	@Parameters
	public static List<Object[]> theParsers() {
	  return Arrays.asList( 
			  new Object[][] {{new ANTLRParser()}}
			 );
	}

	
	public TestStatements(IParse parser) {
		this.parser = parser;
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
	 			ifStatement.class);
	}
}
