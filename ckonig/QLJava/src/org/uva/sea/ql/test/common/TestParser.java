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

	public final Expr parse(String src) throws ParseError {
		return this.parser.parseExpression(src);
	}

	public final Form parseFile() throws ParseError {
		return this.parser.parseDefaultFile();
	}

	public final Form parseFull(String src) throws ParseError {
		return this.parser.parseForm(src);
	}
}
