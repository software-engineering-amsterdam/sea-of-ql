package org.uva.sea.ql.parser.test;

import org.antlr.runtime.*;
import org.uva.sea.ql.parser.antlr.QLLexer;
import org.uva.sea.ql.parser.antlr.QLParser;

public class dotest{
	
public static void main(String[] args) throws ParseError, RecognitionException{
	String source= "form dfgd { hfghf: \"fghfgh\" boolean }";
	ANTLRStringStream stream = new ANTLRStringStream(source);
	CommonTokenStream tokens = new CommonTokenStream();
	tokens.setTokenSource(new QLLexer(stream));
	QLParser parser = new QLParser(tokens);
	parser.form();
	System.out.println("ok dog");
	
}
}

