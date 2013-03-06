package org.uva.sea.ql.test.evaluator;

import static org.junit.Assert.assertEquals;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.uva.sea.ql.ast.values.Evaluator;
import org.uva.sea.ql.ast.values.Value;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.test.ParseError;


public class TestEvaluator {
	private ANTLRParser parser;
	private Evaluator evaluator;
	private Map<String, Value> valuEnv;

	public TestEvaluator() {
		parser = new ANTLRParser();
		valuEnv= new HashMap<String, Value>();
		evaluator = new Evaluator(valuEnv);
	}

	@Test
	public void testExprEvaluation() throws ParseError {
		assertEquals(3, evaluator.evaluate(parser.parseExpr("1 + 2"), valuEnv).getValue());
		assertEquals(true, evaluator.evaluate(parser.parseExpr("true || false"), valuEnv).getValue());
		assertEquals(false, evaluator.evaluate(parser.parseExpr("2 != 2"), valuEnv).getValue());
	}
}