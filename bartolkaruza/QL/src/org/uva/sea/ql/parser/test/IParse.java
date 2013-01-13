package org.uva.sea.ql.parser.test;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.expr.Expr;

public interface IParse {
	Expr parseExpression(String src) throws ParseError;
	ASTNode parseNode(String src) throws ParseError;
}
