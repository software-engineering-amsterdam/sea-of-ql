package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.Question;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.jacc.JaccQLParser;

public class TestStatements {

	private IParse parser;
	
	@Before
	public void setup(){
		parser = new JaccQLParser();
	}
	
	private Class parse(String qlText) throws ParseError{
		return parser.parseStatement(qlText).getClass();
	}
	
	@Test
	public void testQuestion1() throws ParseError {
		assertEquals(Question.class, parse("hasSoldHouse: \"Did you sell a house?\" boolean"));
	}
	
}
