package org.uva.sc.antlr;

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

@RunWith(Parameterized.class)
public class TestQuestions {


	private IParse parser;

	@Parameters
	public static List<Object[]> theParsers() {
	  List<Object[]> retList = new ArrayList<Object[]>();
	  Object[] oArray = {new ANTLRQuestionParser() } ;
	  retList.add(oArray);
	  return retList;
	}

	
	public TestQuestions(IParse parser) {
		this.parser = parser;
	}

	
	@Test
	public void testQuestion() throws ParseError {
		assertEquals(parser.parse("hasSoldHouse : \"Did you sell a house in 2012?\" bool").getClass(), Question.class);
	}
	
	
	
}
