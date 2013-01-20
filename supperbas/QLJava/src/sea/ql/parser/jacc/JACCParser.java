package sea.ql.parser.jacc;

import java.io.StringReader;


import sea.ql.ast.operators.Expr;
import sea.ql.parser.tests.IParse;
import sea.ql.parser.tests.ParseError;

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
