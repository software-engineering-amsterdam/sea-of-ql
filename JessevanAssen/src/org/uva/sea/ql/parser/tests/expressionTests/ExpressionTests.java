package org.uva.sea.ql.parser.tests.expressionTests;

import org.uva.sea.ql.parser.Parser;
import org.uva.sea.ql.parser.antlr.ANTLRParser;

public abstract class ExpressionTests {
	
	protected Parser parser;
	
	public ExpressionTests() {
		this.parser = new ANTLRParser();
	}
	
}
