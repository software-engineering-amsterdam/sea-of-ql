package org.uva.sea.ql.parser.antlr;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.parser.test.IParse;
import org.uva.sea.ql.parser.test.ParseError;

public class ANTLRParser implements IParse {

	public static void main (String args[]) throws RecognitionException {
		CharStream stream = new ANTLRStringStream ("start test =" +
													"question one : String := Would you ?" +
													"question two : String := Would I ?" +
													"question three : String := Woud we?" +
													"end test.");
		QLLexer lexer = new QLLexer (stream);
		TokenStream tokenStream = new CommonTokenStream (lexer);
		QLParser parser = new QLParser (tokenStream);
		parser.program();
		System.out.println("Ok");
	}
	
	@Override
	public Expr parse(String src) throws ParseError {
		ANTLRStringStream stream = new ANTLRStringStream(src);
		CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(new QLLexer(stream));
		QLParser parser = new QLParser(tokens);
		try {
			return parser.orExpr();
		} catch (RecognitionException e) {
			throw new ParseError(e.getMessage());
		}
	}

}
