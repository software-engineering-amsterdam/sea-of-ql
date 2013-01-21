package org.uva.sea.ql.parser.test;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.Expr;

public interface IParse {
	ASTNode parse(String src) throws ParseError;
}
