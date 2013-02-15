package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.expressions.binary.relational.Eq;
import org.uva.sea.ql.ast.expressions.binary.relational.GEq;
import org.uva.sea.ql.ast.expressions.binary.relational.GT;
import org.uva.sea.ql.ast.expressions.binary.relational.LEq;
import org.uva.sea.ql.ast.expressions.binary.relational.LT;
import org.uva.sea.ql.ast.expressions.binary.relational.NEq;
import org.uva.sea.ql.parser.IParser;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.antlr.check.ANTLRParserExpressions;

public class TestBinaryRelationalExpressions {

	private IParser _parser;
	
	public TestBinaryRelationalExpressions() {
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
}