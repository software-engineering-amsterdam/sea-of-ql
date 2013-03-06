package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.checkers.ExprTypeChecker;
//import org.uva.sea.ql.errors.ParseError; why enable it gives error
import org.uva.sea.ql.errors.QLError;
import org.uva.sea.ql.parser.antlr.ANTLRParser;

public class TestExprTypeChecker {

	private ANTLRParser parser;
	private Map<String, Type> typeEnvironment;
	private List<QLError> errors;

	public TestExprTypeChecker() {

		parser = new ANTLRParser();
		errors = new ArrayList<QLError>();
		typeEnvironment = new HashMap<String, Type>();

	}

	@Test
	public void testExprTypeChecker() throws ParseError {

		assertEquals(true, ExprTypeChecker.check(parser.parse("1 - 6 + 2 * (-23) +34"), typeEnvironment, errors));
		assertEquals(true, ExprTypeChecker.check(parser.parse("(4+5)<=(9+0) || true"), typeEnvironment, errors));
		/*
		 * assertEquals(true, ExprTypeChecker.check(
		 * parser.parse("(+5<=-9) && !false || true"), typeEnvironment,
		 * errors));
		 */

	}
}
