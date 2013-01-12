package org.uva.sea.ql.parser.test;

import org.junit.Before;
import org.uva.sea.ql.ast.QLExpression;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.exception.ParseError;

public class TestExpressions {

	private IParse parser;
	
	@Before
	public void prepareTest() {
		
		this.parser = new ANTLRParser();
	}

	protected QLExpression parse(String source) throws ParseError {
		
		return parser.parse(source);
	}
}
