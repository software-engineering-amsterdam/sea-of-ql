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
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.antlr.ANTLRQuestionParser;


public class TestComputedQuestions {


	private IParse parser;

	
	public TestComputedQuestions() {
		this.parser = new ANTLRComputedQuestionParser();
	}

	
	@Test
	public void testComputedQuestion() throws ParseError {
		assertEquals(parser.parse
				("valueResidue : \"Value residue\" int(sellingPrice - privateDebt) ").getClass(), ComputedQuestion.class);
	}
	
	
	
}
