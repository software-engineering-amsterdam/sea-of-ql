package org.uva.sea.ql.parser.test;

import org.uva.sea.ql.ast.Expr;

public class CurrentTest {
	public static IParse parser;

	public static Expr parse(String src) throws ParseError {
		return parser.parse(src);
	}
}
