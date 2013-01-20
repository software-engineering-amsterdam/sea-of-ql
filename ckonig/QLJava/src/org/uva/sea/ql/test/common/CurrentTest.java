package org.uva.sea.ql.test.common;

import java.io.IOException;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.ParseError;

public class CurrentTest {
	private static IParse parser;
	private static final String defaultSrc = "C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\example.ql";
	

	public static void setParser(IParse p) {
		parser = p;
	}

	public static Expr parse(String src) throws ParseError {
		return parser.parseExpression(src);
	}
	public static Expr parseFile() throws ParseError, IOException {
		return parser.parseFile(defaultSrc);
	}
	public static Expr parseFull(String src) throws ParseError {
		return parser.parseForm(src);
	}
}
