package parser;

import java.io.StringReader;

import parser.test.IParse;
import parser.test.ParseError;

import ast.Statement;



public class JACCParser implements IParse {
	@Override
	public Statement parse(String src) throws ParseError {
		QLLexer lexer = new QLLexer(new StringReader(src));
		System.out.println("SOURCE = \"" + src + "\"");
		//System.out.println(lexer.toString());
		lexer.nextToken();
		QLParser parser = new QLParser(lexer);
		System.out.println("xx");
		if (!parser.parse()) {
			throw new ParseError("error");
		}
		System.out.println("AA "+parser.getResult().toString());

		return parser.getResult();
	}

}
