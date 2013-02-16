package org.uva.sea.ql.parser.test;

import org.junit.Test;
import org.uva.sea.ql.ast.expressions.binary.relational.Eq;
import org.uva.sea.ql.ast.expressions.binary.relational.GEq;
import org.uva.sea.ql.ast.expressions.binary.relational.GT;
import org.uva.sea.ql.ast.expressions.binary.relational.LEq;
import org.uva.sea.ql.ast.expressions.binary.relational.LT;
import org.uva.sea.ql.ast.expressions.binary.relational.NEq;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.antlr.check.ANTLRParserExpressions;

public class TestBinaryRelationalExpressions extends ASTNodeChecker {

	public TestBinaryRelationalExpressions() {
		super(new ANTLRParserExpressions());
	}
	
	@Test
	public void testRels() throws ParseError {
		expressionMatchesASTClass("a < b",       LT.class);
		expressionMatchesASTClass("a < b + c",   LT.class);
		expressionMatchesASTClass("a < (b * c)", LT.class);
		expressionMatchesASTClass("(a * b) < c", LT.class);
		
		expressionMatchesASTClass("(a == b)",    Eq.class);
		expressionMatchesASTClass("(a <= b)",    LEq.class);
		expressionMatchesASTClass("(a >= b)",    GEq.class);
		expressionMatchesASTClass("(a != b)",    NEq.class);
		
		expressionMatchesASTClass("a + b > c",   GT.class);
		expressionMatchesASTClass("a > b + c",   GT.class);
	}
}