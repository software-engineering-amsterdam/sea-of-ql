package org.uva.sea.ql.parser.test;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.uva.sea.ql.parser.antlr.QLLexer;
import org.uva.sea.ql.parser.antlr.QLParser;

public class dotest{
	
public static void main(String[] args) throws ParseError{
	ANTLRStringStream stream = new ANTLRStringStream("src > 432");
	CommonTokenStream tokens = new CommonTokenStream();
	tokens.setTokenSource(new QLLexer(stream));
	QLParser parser = new QLParser(tokens);
	try {
		 parser.form();
		 System.out.println("ok dog");
	} catch (RecognitionException e) {
		throw new ParseError(e.getMessage());
	}
}
}

