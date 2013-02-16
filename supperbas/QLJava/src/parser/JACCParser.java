package parser;

import java.io.StringReader;

import parser.test.IParse;
import parser.test.ParseError;

import ast.Form;



public class JACCParser implements IParse {
	@Override
	public Form parse(String src) throws ParseError {
		QLLexer lexer = new QLLexer(new StringReader(src));
		//System.out.println("SOURCE = \"" + src + "\"");
		//System.out.println(lexer.toString());
		lexer.nextToken();
		QLParser parser = new QLParser(lexer);
		//System.out.println(lexer.getColumn());
		//System.out.println("xx");
		if (!parser.parse()) {
			System.out.println(parser.yyerrmsgs);
			System.out.println("xx");
			//System.out.println(lexer.tempStr.toString());
			//System.out.println("ERROR");
			throw new ParseError("error");
		}
		System.out.println("AA "+parser.getResult().toString());

		return parser.getResult();
	}

}
