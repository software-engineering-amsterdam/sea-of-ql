package org.uva.sea.ql.parser.test;

import java.util.ArrayList;
import java.util.Map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.test.ParseError;
import org.uva.sea.ql.parser.typechecker.CheckExpr;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.types.Type;

public class TestCheckExpr {
	private ANTLRParser parser;
	
	private Map<Ident, Type> typeEnv;
	private List<String> errMsgs;

	public TestCheckExpr() {
		parser = new ANTLRParser();
		typeEnv = new HashMap<Ident, Type>();
		errMsgs = new ArrayList<String>();
		
	}

	@Test
	public void testExprChecking() throws ParseError {
		assertTrue(CheckExpr.check(parser.parse("10"), typeEnv, errMsgs));
		//assertTrue(CheckExpr.check(parser.parse("true || false"), typeEnv, errMsgs));
		assertTrue(CheckExpr.check(parser.parse("23 >= 56"), typeEnv, errMsgs));
		assertTrue(CheckExpr.check(parser.parse("25+56*(3/1)"), typeEnv, errMsgs));
		assertTrue(CheckExpr.check(parser.parse("\"abc\"==\"abc\""), typeEnv, errMsgs));
		assertFalse(CheckExpr.check(parser.parse("10-true"), typeEnv, errMsgs));
		assertFalse(CheckExpr.check(parser.parse("true || 20"), typeEnv, errMsgs));
		assertFalse(CheckExpr.check(parser.parse("\"abc\" + 56"), typeEnv, errMsgs));
	}
}