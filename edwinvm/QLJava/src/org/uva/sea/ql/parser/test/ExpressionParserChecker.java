package org.uva.sea.ql.parser.test;

import org.uva.sea.ql.parser.antlr.check.ANTLRParserExpressions;

public class ExpressionParserChecker extends ASTNodeChecker {
	
	public ExpressionParserChecker() {
		super(new ANTLRParserExpressions());
	}
	
}