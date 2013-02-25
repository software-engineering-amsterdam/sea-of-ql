package org.uva.sea.ql.parser.test.evaluation;

import static org.junit.Assert.assertEquals;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.test.ParseError;
import org.uva.sea.ql.evaluator.ExprEvaluator;
import org.uva.sea.ql.evaluator.values.AValue;
import org.uva.sea.ql.evaluator.values.BoolValue;
import org.uva.sea.ql.evaluator.values.IntValue;
import org.uva.sea.ql.evaluator.values.StrValue;

public class TestExprEvaluation {
	private ANTLRParser parser;
	private ExprEvaluator exprEvaluator;
	private Map<Ident, AValue> valEnv;
	
	public TestExprEvaluation() {
		parser = new ANTLRParser();
		valEnv = new HashMap<Ident, AValue>();
		valEnv.put(new Ident("varInt1"), new IntValue(25));
		valEnv.put(new Ident("varInt2"), new IntValue(3));
		valEnv.put(new Ident("varStr1"), new StrValue("string1"));
		valEnv.put(new Ident("varStr2"), new StrValue("string1"));
		valEnv.put(new Ident("varBool1"), new BoolValue(true));
		valEnv.put(new Ident("varBool2"), new BoolValue(false));
		exprEvaluator = new ExprEvaluator(valEnv);
	}
	
	@Test
	public void testExprEvaluation() throws ParseError {
		assertEquals(exprEvaluator.evaluate(parser.parseExpr("varInt1+varInt2"), valEnv).getValue(), 28);
		assertEquals(exprEvaluator.evaluate(parser.parseExpr("varInt1-varInt2"), valEnv).getValue(), 22);
		assertEquals(exprEvaluator.evaluate(parser.parseExpr("varInt1==varInt2"), valEnv).getValue(), false);
		assertEquals(exprEvaluator.evaluate(parser.parseExpr("varInt1>varInt2"), valEnv).getValue(), true);
		assertEquals(exprEvaluator.evaluate(parser.parseExpr("-varInt1"), valEnv).getValue(), -25);
		
		assertEquals(exprEvaluator.evaluate(parser.parseExpr("varStr1==varStr2"), valEnv).getValue(), true);
		assertEquals(exprEvaluator.evaluate(parser.parseExpr("varStr1!=varStr2"), valEnv).getValue(), false);
		
		assertEquals(exprEvaluator.evaluate(parser.parseExpr("varBool1 && varBool2"), valEnv).getValue(), false);
		assertEquals(exprEvaluator.evaluate(parser.parseExpr("varBool1 || varBool2"), valEnv).getValue(), true);
		assertEquals(exprEvaluator.evaluate(parser.parseExpr("!varBool1"), valEnv).getValue(), false);
	}
}