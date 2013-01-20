package org.uva.sea.ql.parser.jacc;

import java.io.StringReader;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.ParseError;

public class JaccQLParser implements IParse {
	@Override
	public Expr parse(String src) throws ParseError {
		QLLexer lexer = new QLLexer(new StringReader(src));
		lexer.nextToken();
		org.uva.sea.ql.parser.jacc.QLParser parser = new org.uva.sea.ql.parser.jacc.QLParser(lexer);
		if (!parser.parse()) {
			throw new ParseError("error");
		}
		return parser.getResult();
	}

}
