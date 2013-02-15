package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.expressions.binary.logical.And;
import org.uva.sea.ql.ast.expressions.binary.logical.Or;
import org.uva.sea.ql.parser.IParser;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.antlr.check.ANTLRParserExpressions;

public class TestBinaryLogicalExpressions {

	private IParser _parser;
	
	public TestBinaryLogicalExpressions() {
		_parser = new ANTLRParserExpressions();
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