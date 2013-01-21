package parser.jacc;

import java.io.StringReader;

import parser.tests.IParse;
import parser.tests.ParseError;

import ast.Expression;



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
