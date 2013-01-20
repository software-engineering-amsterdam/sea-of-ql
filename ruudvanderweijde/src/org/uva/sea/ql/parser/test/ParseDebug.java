package org.uva.sea.ql.parser.test;

import org.uva.sea.ql.parser.ANTLRParser;

public class ParseDebug {

	/**
	 * @param args
	 */	
	public static void main(String[] args) throws ParseError {
		IParse parser = new ANTLRParser();
		String strQL = "form Ident { ";
		strQL += "question1: \"Q1\" boolean ";
		strQL += "question2: \"Q2\" string ";
		strQL += "}";
		System.out.println(parser.parseForm(strQL).getClass());
	}
}
