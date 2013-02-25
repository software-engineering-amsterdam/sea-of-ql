package org.uva.sea.ql.parser;

import java.io.StringReader;

import org.uva.sea.ql.ast.Node;

public class JACCParser implements IParser {
	@Override
	public Node parse(final String src) {
		return this.parse(src, "test");
	}

	@Override
	public Node parse(final String src, final String fileName) {
		final Lexer lexer = new Lexer(new StringReader(src), fileName);
		lexer.nextToken();
		final Parser parser = new Parser(lexer);
		parser.parse();
		return parser.getResult();
	}
}
