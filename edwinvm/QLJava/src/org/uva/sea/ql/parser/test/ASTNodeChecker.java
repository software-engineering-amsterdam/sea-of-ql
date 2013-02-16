package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.parser.IParser;
import org.uva.sea.ql.parser.ParseError;

public class ASTNodeChecker {
	
	private final IParser _parser;
	
	public ASTNodeChecker(IParser parser) {
		_parser = parser;
	}
	
	public void inputMatchesFormAST(String input) throws ParseError {
		assertEquals(getAstNodeFor(input), Form.class);
	}
	
	public void expressionMatchesASTClass(String input, Class<?> astNode) throws ParseError {
		match(input, astNode);
	}
	
	public void match(String input, Class<?> astNode) throws ParseError {
		assertEquals(getAstNodeFor(input), astNode);
	}
	
	public Class<?> getAstNodeFor(String input) throws ParseError {
		return parse(input).getClass();
	}
	
	public ASTNode parse(String input) throws ParseError {
		return _parser.parse(input);
	}
	
}