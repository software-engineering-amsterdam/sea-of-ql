package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.expressions.unary.Neg;
import org.uva.sea.ql.ast.expressions.unary.Not;
import org.uva.sea.ql.ast.expressions.unary.Pos;
import org.uva.sea.ql.parser.IParser;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.antlr.check.ANTLRParserExpressions;

public class TestUnaryExpressions {

	private IParser _parser;
	
	public TestUnaryExpressions() {
		_parser = new ANTLRParserExpressions();
	}
	
	@Test
	public void testNegs() throws ParseError {
		assertEquals(_parser.parse("--x").getClass(), Neg.class);
	}
	
	@Test
	public void testPoss() throws ParseError {
		assertEquals(_parser.parse("++x").getClass(), Pos.class);
	}
	
	@Test
	public void testNots() throws ParseError {
		assertEquals(_parser.parse("!hasBoughtHouse").getClass(), Not.class);
	}
}