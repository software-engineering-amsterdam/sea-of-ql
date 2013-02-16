package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import org.uva.sea.ql.ast.statements.ConditionBlock;
import org.uva.sea.ql.parser.IParser;
import org.uva.sea.ql.parser.ParseError;

public class StatementParserChecker extends ASTNodeChecker {
	
	public StatementParserChecker(IParser parser) {
		super(parser);
	}
	
	public void statementMatchesConditionBlock(String input) throws ParseError {
		assertEquals(getAstNodeFor(input), ConditionBlock.class);
	}
	
}