package org.uva.sea.ql.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.uva.sea.ql.Evaluator;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.values.Value;

public class TestExprEvaluator {

	private ANTLRParser parser;
	private Map<String,Value> env;

	public TestExprEvaluator() {
		
		parser = new ANTLRParser();
		env = new HashMap<String, Value> ();
	}
	
	@Test
	public void testExprTypeChecker() throws ParseError {
		Expr expr=parser.parse("5>6 || 7<9");
		Value v = Evaluator.eval(expr, env);
		
		System.out.println(v.getValue());
		
	}

}

