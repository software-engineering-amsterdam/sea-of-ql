package org.uva.sea.ql.parser.test;

import org.junit.Test;
import org.uva.sea.ql.ast.expressions.binary.logical.And;
import org.uva.sea.ql.ast.expressions.binary.logical.Or;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.antlr.check.ANTLRParserExpressions;

public class TestBinaryLogicalExpressions extends ASTNodeChecker {

	public TestBinaryLogicalExpressions() {
		super(new ANTLRParserExpressions());
	}
	
	@Test
	public void testAnds() throws ParseError {
		expressionMatchesASTClass("a && b",      And.class);
		expressionMatchesASTClass("a && b <= c", And.class);
	}
	
	@Test
	public void testOrs() throws ParseError {
		expressionMatchesASTClass("a || b",      Or.class);
		expressionMatchesASTClass("a || b <= c", Or.class);
	}
}