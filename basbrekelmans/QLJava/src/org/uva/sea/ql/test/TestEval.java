package org.uva.sea.ql.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.expressions.Expression;
import org.uva.sea.ql.parser.IParser;
import org.uva.sea.ql.parser.JACCParser;
import org.uva.sea.ql.runtime.ExpressionEvaluator;
import org.uva.sea.ql.runtime.IExpressionEvaluator;

public class TestEval {

	@Test
	public void TestLiteralEvaluation() {
		IParser parser = new JACCParser();
		IExpressionEvaluator eval = new ExpressionEvaluator(null);
		assertEquals(8L, eval.getValue((Expression)parser.parse("5 + 3")).getValue());
		assertEquals(8.0, eval.getValue((Expression)parser.parse("5.0 + 3")).getValue());
		assertEquals(1L, eval.getValue((Expression)parser.parse("3 / 2")).getValue());
		assertEquals(1.5, eval.getValue((Expression)parser.parse("3 / 2.0")).getValue());
		assertEquals(12L, eval.getValue((Expression)parser.parse("5 + 3 + 8 + 1 - 5")).getValue());
		assertEquals(35.1, eval.getValue((Expression)parser.parse("5.1 + 3 * 10")).getValue());
		assertEquals(1L, eval.getValue((Expression)parser.parse("3 / 2 + 7 - 7")).getValue());
		assertEquals(false, eval.getValue((Expression)parser.parse("false || false")).getValue());
		assertEquals(true, eval.getValue((Expression)parser.parse("true ^ false")).getValue());
		assertEquals(true, eval.getValue((Expression)parser.parse("true || false")).getValue());
		assertEquals(false, eval.getValue((Expression)parser.parse("true && false")).getValue());
		assertEquals(false, eval.getValue((Expression)parser.parse("5 + 8 == 9 - 1")).getValue());
		assertEquals(false, eval.getValue((Expression)parser.parse("5 + 8 == 13.0")).getValue());
		assertEquals(true, eval.getValue((Expression)parser.parse("\"Hanky\" == \"Hanky\"")).getValue());
		assertEquals(false, eval.getValue((Expression)parser.parse("\"Hank5y\" == 13.0")).getValue());
	}
}
