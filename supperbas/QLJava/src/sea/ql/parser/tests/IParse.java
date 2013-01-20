package sea.ql.parser.tests;

import sea.ql.ast.operators.Expr;

public interface IParse {
	Expr parse(String src) throws ParseError;
}
