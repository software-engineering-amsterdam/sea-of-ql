package org.uva.sea.ql.parser.antlr;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.expr.grouping.Expr;

public interface IParse {
	Expr parseExpression(String src) throws ParseError;
	ASTNode parseNode(String src) throws ParseError;
}
