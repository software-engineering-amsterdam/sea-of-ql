package org.uva.sea.ql.parser.jacc;

import java.io.StringReader;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.parser.test.IParse;
import org.uva.sea.ql.parser.test.ParseError;

public class JACCParser implements IParse {
	@Override
	public ASTNode parse(String src) throws ParseError {
		QLLexer lexer = new QLLexer(new StringReader(src));
		System.out.println("SOURCE = \"" + src + "\"");
		lexer.nextToken();
		QLParser parser = new QLParser(lexer);
		if (!parser.parse()) {
			throw new ParseError("error");
		}
		return parser.getResult();
	}

}
