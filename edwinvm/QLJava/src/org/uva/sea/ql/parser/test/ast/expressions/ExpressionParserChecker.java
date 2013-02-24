package org.uva.sea.ql.parser.test.ast.expressions;

import org.uva.sea.ql.parser.antlr.check.ANTLRParserExpressions;
import org.uva.sea.ql.parser.errors.ParseError;
import org.uva.sea.ql.parser.test.ast.ASTNodeChecker;

public class ExpressionParserChecker extends ASTNodeChecker {
	
	public ExpressionParserChecker() {
		super(new ANTLRParserExpressions());
	}
	
	public void expressionMatchesASTClass(String input, Class<?> astNode) throws ParseError { match(input, astNode); }
	
}