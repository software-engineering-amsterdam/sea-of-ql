package org.uva.sea.ql.parser.test.semantic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitor.CheckExpr;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.test.IParse;
import org.uva.sea.ql.parser.test.ParseError;

public class TestCheckExpr {

	private IParse parser;
	private CheckExpr checkExpr;
	private Map<String, Type> tenv; 
	private List<String> messages;

	public TestCheckExpr() {
		parser = new ANTLRParser();
		tenv = new HashMap<String, Type>();
		messages = new ArrayList<String>();
		checkExpr = new CheckExpr(tenv, messages);
	}
	
	@Test
	public void testExprChecking() throws ParseError {
		assertEquals(true, checkExpr.check(parser.parseExpr("1 + 2"), tenv, messages));
		assertEquals(true, checkExpr.check(parser.parseExpr("true || false"), tenv, messages));
		assertEquals(true, checkExpr.check(parser.parseExpr("2 >= 1"), tenv, messages));
		assertEquals(false, checkExpr.check(parser.parseExpr("1-true"), tenv, messages));
		assertEquals(false, checkExpr.check(parser.parseExpr("true || 2"), tenv, messages));
		assertEquals(false, checkExpr.check(parser.parseExpr("\"abc\" + 1"), tenv, messages));
	}
}
