package parser;

import java.io.StringReader;

import parser.tests.IParse;
import parser.tests.ParseError;

import ast.Expr;



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
