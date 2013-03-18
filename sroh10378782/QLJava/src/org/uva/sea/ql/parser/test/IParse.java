package org.uva.sea.ql.parser.test;

import org.uva.sea.ql.ast.nodes.expressions.Expr;
import org.uva.sea.ql.ast.nodes.statements.Statement;

public interface IParse {
	Expr parse(String src) throws ParseError;
	Statement start(String src) throws ParseError;
}
