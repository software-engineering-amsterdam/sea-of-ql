package org.uva.sea.ql.parser.test;

import org.uva.sea.ql.parser.antlr.ANTLRParser;

public class ParseDebug {

	/**
	 * @param args
	 */	
	public static void main(String[] args) throws ParseError {
		IParse parser = new ANTLRParser();
		System.out.println(parser.parse("identa-Ident").getClass());
	}
}
