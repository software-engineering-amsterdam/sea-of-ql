package org.uva.sea.ql.parser.antlr;

import org.antlr.runtime.*;

public class QLRun {

	public static void main(String[] args) throws Exception {
		ANTLRStringStream in = new ANTLRStringStream("s sa jdbajskbd sa djkb ash");
		QLLexer lexer = new QLLexer(in);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		QLParser parser = new QLParser(tokens);
		System.out.println("tokennames: " + parser.getTokenNames());

	}

}
