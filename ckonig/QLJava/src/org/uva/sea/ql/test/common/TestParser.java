package org.uva.sea.ql.test.common;

import org.uva.sea.ql.ast.elements.Form;
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

	public Form parseFile() throws ParseError {
		return parser.parseDefaultFile();
	}

	public Form parseFull(String src) throws ParseError {
		return parser.parseForm(src);
	}
}
