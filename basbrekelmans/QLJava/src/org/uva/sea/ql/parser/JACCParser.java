package org.uva.sea.ql.parser;

import java.io.StringReader;
import org.uva.sea.ql.ast.Node;

public class JACCParser implements IParser {
	@Override
	public Node parse(String src) throws ParseError {
		Lexer lexer = new Lexer(new StringReader(src), "test");
		lexer.nextToken();
		Parser parser = new Parser(lexer);
		parser.parse();
		return parser.getResult();
	}
}
