package org.uva.sea.ql.test.common;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.ParseError;

public class TestParser {
	private IParse parser;

	public TestParser(IParse p) {
		this.parser = p;
	}

	public Expr parse(String src) throws ParseError {
		return parser.parseExpression(src);
	}

	public Expr parseFile() throws ParseError {
		return parser.parseDefaultFile();
	}

	public Expr parseFull(String src) throws ParseError {
		return parser.parseForm(src);
	}
}
