package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.expressions.Int;
import org.uva.sea.ql.ast.expressions.Mul;
import org.uva.sea.ql.parser.antlr.ANTLRParser;

public class TestComments {

	private IParse parser;

	@Before
	public void setUp() {
		parser = new ANTLRParser();
	}
	
	@Test
	public void testMultiLineComment() throws ParseError {
		assertEquals(Mul.class, parser.parseExpr("/* a + /n b + */ c * d").getClass());
	}
	
	@Test
	public void testSingleLineComment() throws ParseError {
		assertEquals(Mul.class, parser.parseExpr("// a + \n b * c").getClass());
		assertEquals(Int.class, parser.parseExpr("// a + b * c \n 5").getClass());
	}

}
