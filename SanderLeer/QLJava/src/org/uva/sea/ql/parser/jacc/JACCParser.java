package org.uva.sea.ql.parser.jacc;

import java.io.StringReader;
import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.parser.ParseException;
import org.uva.sea.ql.parser.Parser;

public class JACCParser implements Parser {
	@Override
	public ASTNode parse(String src) throws ParseException {
		QLLexer lexer = new QLLexer(new StringReader(src));

		QLParser parser = new QLParser(lexer);
		if (!parser.parse()) {
			throw new ParseException("parse error: " + parser.getError());
		}
		ASTNode ast = parser.getResult();

		return ast;
	}
}
