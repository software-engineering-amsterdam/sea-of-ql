package org.uva.sea.ql.parser.jacc;

import java.io.StringReader;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.ParseError;

public class JACCParser implements IParse {
	@Override
	public Expression parse(String src) throws ParseError {
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
