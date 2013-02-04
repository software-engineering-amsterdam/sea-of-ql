package org.uva.sea.ql.tests.parser.parserTests;

import static org.junit.Assert.*;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.Parser;
import org.uva.sea.ql.parser.antlr.ANTLRParser;

public abstract class ParserTests {
	
	protected final Parser parser;
	
	public ParserTests() {
		this.parser = new ANTLRParser();
	}
	
	protected Statement parseStatement(String statement) throws ParseError {
		final String template = "form default { %s }";
		
		Form parsed = parser.parse(String.format(template, statement));
		assertNotNull(parsed.getBody());
        return parsed.getBody();
	}
	
	protected Expr parseExpression(String expression) throws ParseError {
		final String template = "if(%s) { }";
		
		Statement parsed = parseStatement(String.format(template, expression));
		return ((If) parsed).getCondition();
	}
}
