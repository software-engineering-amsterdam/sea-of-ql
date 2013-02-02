package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.uva.sea.ql.ast.ExprTypeChecker;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.parser.antlr.ANTLRParser;

public class TestExprTypeChecker {

	private ANTLRParser parser;
	private Map<String,Type> typeEnvironment;
	private List<String> errors;
	//private ExprTypeChecker typeChecker;

	public TestExprTypeChecker() {
		
		parser = new ANTLRParser();
		errors = new ArrayList<String>();
		typeEnvironment = new HashMap<String, Type> ();
		//typeChecker = new ExprTypeChecker(typeEnvironment,errors);

	}
	
	@Test
	public void testExprTypeChecker() throws ParseError {
		
		assertEquals(true, ExprTypeChecker.check(parser.parse("5 + 6 + 2 * (-23) +34"),typeEnvironment, errors));
		assertEquals(true, ExprTypeChecker.check(parser.parse("5<=9 || true"), typeEnvironment, errors));
		assertEquals(true, ExprTypeChecker.check(parser.parse("(+5<=-9) && !false || true"), typeEnvironment, errors));
		
	}
	
	
	
}