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
import org.uva.sea.ql.parser.antlr.ANTLRFormParser;
import org.uva.sea.ql.parser.antlr.ANTLRIfThenElseStatementParser;
import org.uva.sea.ql.parser.antlr.ANTLRIfThenStatementParser;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.antlr.ANTLRQuestionParser;


public class TestForm {


	private IParse parser;

	
	public TestForm() {
		this.parser = new ANTLRFormParser();
	}

	
	@Test
	public void testForm() throws ParseError {
		assertEquals(parser.parse
				(		"form Box1HouseOwning { "
						+ " hasSoldHouse : \"Did you sell a house in 2010?\" bool "
						+ " hasBoughtHouse : \"Did you buy a house in 2010?\" bool "	
						+ " if (hasSoldHouse) then { "  
						+ 	" valueResidue : \"Value residue\" int(sellingPrice - privateDebt) "
						+ 	" } "
						+ " else { "
						+ 	" valueResidueMin : \"Value residue min\" int(privateDebt - sellingPrice) "	
						+ 	" hasMaintLoan: \"Did you enter a loan for maintenance or reconstruction\" bool "
						+ "} "
						+ "}").getClass(), QLForm.class);
	}
	
	
	
}
