package org.uva.sea.ql.parser.jacc;

import java.io.StringReader;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.util.LogPrinter;

public class JACCParser implements IParse {
	@Override
	public ASTNode parse(final String src) throws ParseError {
		QLLexer lexer = new QLLexer(new StringReader(src));

		LogPrinter.debugInfo(src);

		lexer.nextToken();
		QLParser parser = new QLParser(lexer);
		if (!parser.parse()) {
			throw new ParseError("error");
		}
		return parser.getResult();
	}

}
