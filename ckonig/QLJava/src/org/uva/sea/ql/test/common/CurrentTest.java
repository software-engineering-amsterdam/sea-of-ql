package org.uva.sea.ql.test.common;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.ParseError;

public class CurrentTest {
	private static IParse parser;

	public static void setParser(IParse p) {
		parser = p;
	}

	public static Expr parse(String src) throws ParseError {
		return parser.parseExpression(src);
	}
	public static Expr parseFile() throws ParseError {
		return parser.parseDefaultFile();
	}
	public static Expr parseFull(String src) throws ParseError {
		return parser.parseForm(src);
	}
}
