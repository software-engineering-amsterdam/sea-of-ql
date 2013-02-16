package org.uva.sea.ql.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.uva.sea.ql.Evaluator;
import org.uva.sea.ql.ExprTypeChecker;
import org.uva.sea.ql.QLError;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.values.Value;

public class TestExprTypeChecker {

	private ANTLRParser parser;
	private Map<String,Type> typeEnvironment;
	private List<QLError> errors;
	
	private Map<String, Value> env;
	//private ExprTypeChecker typeChecker;

	public TestExprTypeChecker() {
		
		parser = new ANTLRParser();
		errors = new ArrayList<QLError>();
		typeEnvironment = new HashMap<String, Type> ();
		//typeChecker = new ExprTypeChecker(typeEnvironment,errors);

	}
	
	@Test
	public void testExprTypeChecker() throws ParseError {
		
		assertEquals(true, ExprTypeChecker.check(parser.parse("1 - 6 + 2 * (-23) +34"),typeEnvironment, errors));
		assertEquals(true, ExprTypeChecker.check(parser.parse("(4+5)<=(9+0) || true"), typeEnvironment, errors));
		assertEquals(true, ExprTypeChecker.check(parser.parse("(+5<=-9) && !false || true"), typeEnvironment, errors));
		
		
		
	}

}