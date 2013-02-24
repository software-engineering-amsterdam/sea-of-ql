package org.uva.sea.ql.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.errors.ParseError;
import org.uva.sea.ql.evaluation.Evaluator;
import org.uva.sea.ql.evaluation.values.Value;
import org.uva.sea.ql.parser.antlr.ANTLRParser;

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

