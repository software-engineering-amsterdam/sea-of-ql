package org.uva.sea.ql.parser.tests.parserTests;

import static org.junit.Assert.*;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.Parser;
import org.uva.sea.ql.parser.antlr.ANTLRParser;

public abstract class ParserTests {
	
	protected Parser parser;
	
	public ParserTests() {
		this.parser = new ANTLRParser();
	}
	
	protected FormElement parseFormElement(String formElement) throws ParseError {
		final String template = "form default { %s }";
		
		Form parsed = (Form) parser.parse(String.format(template, formElement));
		assertNotNull(parsed.getBody());
		assertEquals(1, parsed.getBody().size());
		
		return parsed.getBody().get(0);
	}
	
	protected Expr parseExpression(String expression) throws ParseError {
		final String template = "if(%s) { }";
		
		FormElement parsed = parseFormElement(String.format(template, expression));
		return ((If) parsed).getCondition();
	}
}
