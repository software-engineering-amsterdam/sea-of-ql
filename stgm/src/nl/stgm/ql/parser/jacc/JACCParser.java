package nl.stgm.ql.parser.jacc;

import java.io.StringReader;

import nl.stgm.ql.ast.Expr;
import nl.stgm.ql.parser.test.IParse;
import nl.stgm.ql.parser.test.ParseError;

public class JACCParser implements IParse {
	@Override
	public Expr parse(String src) throws ParseError {
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
