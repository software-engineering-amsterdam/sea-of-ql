package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import org.uva.sea.ql.parser.IParser;
import org.uva.sea.ql.parser.ParseError;

public class ASTNodeChecker {
	
	private IParser _parser;
	
	public ASTNodeChecker(IParser parser) {
		_parser = parser;
	}
	
	public void expressionMatchesASTClass(String input, Class<?> astNode) throws ParseError {
		assertEquals(_parser.parse(input).getClass(), astNode);
	}
}