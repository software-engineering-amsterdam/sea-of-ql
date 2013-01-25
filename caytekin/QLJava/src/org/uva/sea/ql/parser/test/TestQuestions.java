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
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.antlr.ANTLRQuestionParser;


public class TestQuestions {


	private IParse parser;

	
	public TestQuestions() {
		this.parser = new ANTLRQuestionParser();
	}

	
	@Test
	public void testQuestion() throws ParseError {
		assertEquals(parser.parse("hasSoldHouse : \"Did you sell a house in 2012?\" bool ").getClass(), Question.class);
	}
	
	
	
}
