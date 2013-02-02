package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.expressions.binary.bool.And;
import org.uva.sea.ql.ast.expressions.binary.bool.Eq;
import org.uva.sea.ql.ast.expressions.binary.bool.GEq;
import org.uva.sea.ql.ast.expressions.binary.bool.GT;
import org.uva.sea.ql.ast.expressions.binary.bool.LEq;
import org.uva.sea.ql.ast.expressions.binary.bool.LT;
import org.uva.sea.ql.ast.expressions.binary.bool.NEq;
import org.uva.sea.ql.ast.expressions.binary.bool.Or;
import org.uva.sea.ql.parser.IParser;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.antlr.check.ANTLRParserExpressions;

public class TestBinaryBoolExpressions {

	private IParser _parser;
	
	public TestBinaryBoolExpressions() {
		_parser = new ANTLRParserExpressions();
	}
	
	@Test
	public void testRels() throws ParseError {
		assertEquals(_parser.parse("a < b").getClass(), LT.class);
		assertEquals(_parser.parse("a < b + c").getClass(), LT.class);
		assertEquals(_parser.parse("a < (b * c)").getClass(), LT.class);
		assertEquals(_parser.parse("(a * b) < c").getClass(), LT.class);
		
		assertEquals(_parser.parse("(a == b)").getClass(), Eq.class);
		assertEquals(_parser.parse("(a <= b)").getClass(), LEq.class);
		assertEquals(_parser.parse("(a >= b)").getClass(), GEq.class);
		assertEquals(_parser.parse("(a != b)").getClass(), NEq.class);
		
		assertEquals(_parser.parse("a + b > c").getClass(), GT.class);
		assertEquals(_parser.parse("a > b + c").getClass(), GT.class);
	}
	
	@Test
	public void testAnds() throws ParseError {
		assertEquals(_parser.parse("a && b").getClass(), And.class);
		assertEquals(_parser.parse("a && b <= c").getClass(), And.class);
	}
	
	@Test
	public void testOrs() throws ParseError {
		assertEquals(_parser.parse("a || b").getClass(), Or.class);
		assertEquals(_parser.parse("a || b <= c").getClass(), Or.class);
	}
}