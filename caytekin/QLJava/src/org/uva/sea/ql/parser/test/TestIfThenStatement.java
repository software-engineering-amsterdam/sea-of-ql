package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.parser.antlr.ANTLRComputedQuestionParser;
import org.uva.sea.ql.parser.antlr.ANTLRIfThenStatementParser;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.antlr.ANTLRQuestionParser;

public class TestIfThenStatement {


	private IParse parser;

	public TestIfThenStatement() {
		this.parser = new ANTLRIfThenStatementParser();
	}

	
	@Test
	public void testIfThenStatement() throws ParseError {
		assertEquals(parser.parse
				("if (hasSoldHouse) then {"  
						+ "valueResidue : \"Value residue\" int(sellingPrice - privateDebt)"
						+ "valueResidue2 : \"value residue 2 \" int"
						+ "}").getClass(), IfThenStatement.class);
	}
	
	
	
}
