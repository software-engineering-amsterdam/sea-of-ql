package org.uva.sea.ql.parser.test.evaluation;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.parser.antlr.ParseError;
import org.uva.sea.ql.parser.evaluator.ExpressionEvaluator;
import org.uva.sea.ql.parser.evaluator.result.BoolValue;
import org.uva.sea.ql.parser.evaluator.result.IntValue;
import org.uva.sea.ql.parser.evaluator.result.StrValue;
import org.uva.sea.ql.parser.evaluator.result.Value;
import org.uva.sea.ql.parser.test.AbstractTest;

public class EvaluationTest extends AbstractTest {
	
	private ExpressionEvaluator evaluator;
	
	public EvaluationTest() {
		Map<Ident, Value> symbolTable = new HashMap<>();
		
		symbolTable.put(new Ident("five", null), new IntValue(5));
		symbolTable.put(new Ident("ten", null), new IntValue(10));
		
		symbolTable.put(new Ident("yes", null), new BoolValue(true));
		symbolTable.put(new Ident("no", null), new BoolValue(false));
		
		
		symbolTable.put(new Ident("fname", null), new StrValue("sven"));
		symbolTable.put(new Ident("lname", null), new StrValue("meyer"));
		
		this.evaluator = new ExpressionEvaluator(symbolTable);
	}
	
	private Value evaluate(String src) throws ParseError {
		return getParser().parseExpression(src).accept(getEvaluator());
	}
	
	private ExpressionEvaluator getEvaluator() {
		return evaluator;
	}
	

	@Test
	public void testValues() throws ParseError {
		assertEquals(new IntValue(10), evaluate("ten"));
		assertEquals(new IntValue(10), evaluate("10"));
		
		assertEquals(new BoolValue(true), evaluate("yes"));
		assertEquals(new BoolValue(true), evaluate("true"));
		assertEquals(new BoolValue(false), evaluate("false"));
		
		assertEquals(new StrValue("sven"), evaluate("\"sven\""));
		assertEquals(new StrValue("sven"), evaluate("fname"));
	}
	
	@Test
	public void testArithmetic() throws ParseError {
		assertEquals(new IntValue(15), evaluate("ten + five"));
		assertEquals(new IntValue(15), evaluate("10 + 5"));
		
		assertEquals(new IntValue(5), evaluate("ten - five"));
		assertEquals(new IntValue(5), evaluate("10 - 5"));
		
		assertEquals(new IntValue(50), evaluate("ten * five"));
		assertEquals(new IntValue(50), evaluate("10 * 5"));
		
		assertEquals(new IntValue(2), evaluate("ten / five"));
		assertEquals(new IntValue(2), evaluate("10 / 5"));
		
		assertEquals(new IntValue(10), evaluate("+ ten"));
		assertEquals(new IntValue(10), evaluate("+ 10"));
		
		assertEquals(new IntValue(-10), evaluate("- ten"));
		assertEquals(new IntValue(-10), evaluate("- 10"));
		
	}
	
	@Test
	public void testEquality() throws ParseError {
		/* Int */
		assertEquals(new BoolValue(false), evaluate("ten == five"));
		assertEquals(new BoolValue(false), evaluate("ten == 5"));
		assertEquals(new BoolValue(false), evaluate("10 == five"));
		assertEquals(new BoolValue(false), evaluate("10 == 5"));
		
		assertEquals(new BoolValue(true), evaluate("ten == ten"));
		assertEquals(new BoolValue(true), evaluate("ten == 10"));
		assertEquals(new BoolValue(true), evaluate("10 == 10"));
		
		/* Str */
		assertEquals(new BoolValue(false), evaluate("fname == lname"));
		assertEquals(new BoolValue(false), evaluate("fname == \"meyer\""));
		assertEquals(new BoolValue(false), evaluate("\"sven\" == lname"));
		assertEquals(new BoolValue(false), evaluate("\"sven\" == \"meyer\""));
		
		assertEquals(new BoolValue(true), evaluate("fname == fname"));
		assertEquals(new BoolValue(true), evaluate("\"sven\" == fname"));
		assertEquals(new BoolValue(true), evaluate("\"sven\" == \"sven\""));
		
		/* Bool */
		assertEquals(new BoolValue(false), evaluate("yes == no"));
		assertEquals(new BoolValue(false), evaluate("yes == false"));
		assertEquals(new BoolValue(false), evaluate("true == no"));
		assertEquals(new BoolValue(false), evaluate("true == false"));
		
		assertEquals(new BoolValue(true), evaluate("yes == yes"));
		assertEquals(new BoolValue(true), evaluate("yes == true"));
		assertEquals(new BoolValue(true), evaluate("true == true"));
	}
	
	@Test
	public void testInEquality() throws ParseError {
		/* Int */
		assertEquals(new BoolValue(true), evaluate("ten != five"));
		assertEquals(new BoolValue(true), evaluate("ten != 5"));
		assertEquals(new BoolValue(true), evaluate("10 != five"));
		assertEquals(new BoolValue(true), evaluate("10 != 5"));
		
		assertEquals(new BoolValue(false), evaluate("ten != ten"));
		assertEquals(new BoolValue(false), evaluate("ten != 10"));
		assertEquals(new BoolValue(false), evaluate("10 != 10"));
		
		/* Str */
		assertEquals(new BoolValue(true), evaluate("fname != lname"));
		assertEquals(new BoolValue(true), evaluate("fname != \"meyer\""));
		assertEquals(new BoolValue(true), evaluate("\"sven\" != lname"));
		assertEquals(new BoolValue(true), evaluate("\"sven\" != \"meyer\""));
		
		assertEquals(new BoolValue(false), evaluate("fname != fname"));
		assertEquals(new BoolValue(false), evaluate("\"sven\" != fname"));
		assertEquals(new BoolValue(false), evaluate("\"sven\" != \"sven\""));
		
		/* Bool */
		assertEquals(new BoolValue(true), evaluate("yes != no"));
		assertEquals(new BoolValue(true), evaluate("yes != false"));
		assertEquals(new BoolValue(true), evaluate("true != no"));
		assertEquals(new BoolValue(true), evaluate("true != false"));
		
		assertEquals(new BoolValue(false), evaluate("yes != yes"));
		assertEquals(new BoolValue(false), evaluate("yes != true"));
		assertEquals(new BoolValue(false), evaluate("true != true"));
	}
	
	@Test
	public void testComparison() throws ParseError {
		assertEquals(new BoolValue(true), evaluate("ten > five"));
		assertEquals(new BoolValue(true), evaluate("ten > 5"));
		assertEquals(new BoolValue(true), evaluate("10 > five"));
		assertEquals(new BoolValue(true), evaluate("10 > 5"));
		
		assertEquals(new BoolValue(false), evaluate("ten > ten"));
		assertEquals(new BoolValue(false), evaluate("ten > 10"));
		assertEquals(new BoolValue(false), evaluate("10 > 10"));
		
		assertEquals(new BoolValue(true), evaluate("ten >= five"));
		assertEquals(new BoolValue(true), evaluate("ten >= 5"));
		assertEquals(new BoolValue(true), evaluate("10 >= five"));
		assertEquals(new BoolValue(true), evaluate("10 >= 5"));
		
		assertEquals(new BoolValue(true), evaluate("ten >= ten"));
		assertEquals(new BoolValue(true), evaluate("ten >= 10"));
		assertEquals(new BoolValue(true), evaluate("10 >= 10"));
		
		assertEquals(new BoolValue(false), evaluate("ten < five"));
		assertEquals(new BoolValue(false), evaluate("ten < 5"));
		assertEquals(new BoolValue(false), evaluate("10 < five"));
		assertEquals(new BoolValue(false), evaluate("10 < 5"));
		
		assertEquals(new BoolValue(false), evaluate("ten < ten"));
		assertEquals(new BoolValue(false), evaluate("ten < 10"));
		assertEquals(new BoolValue(false), evaluate("10 < 10"));
		
		assertEquals(new BoolValue(false), evaluate("ten <= five"));
		assertEquals(new BoolValue(false), evaluate("ten <= 5"));
		assertEquals(new BoolValue(false), evaluate("10 <= five"));
		assertEquals(new BoolValue(false), evaluate("10 <= 5"));
		
		assertEquals(new BoolValue(true), evaluate("ten <= ten"));
		assertEquals(new BoolValue(true), evaluate("ten <= 10"));
		assertEquals(new BoolValue(true), evaluate("10 <= 10"));
	}
	
	@Test
	public void testBools() throws ParseError {
		assertEquals(new BoolValue(false), evaluate("yes && no"));
		assertEquals(new BoolValue(false), evaluate("yes && false"));
		assertEquals(new BoolValue(false), evaluate("true && no"));
		assertEquals(new BoolValue(false), evaluate("true && false"));
		
		assertEquals(new BoolValue(true), evaluate("yes && yes"));
		assertEquals(new BoolValue(true), evaluate("yes && true"));
		assertEquals(new BoolValue(true), evaluate("true && true"));
		
		assertEquals(new BoolValue(true), evaluate("yes || no"));
		assertEquals(new BoolValue(true), evaluate("yes || false"));
		assertEquals(new BoolValue(true), evaluate("true || no"));
		assertEquals(new BoolValue(true), evaluate("true || false"));
		
		assertEquals(new BoolValue(true), evaluate("yes || yes"));
		assertEquals(new BoolValue(true), evaluate("yes || true"));
		assertEquals(new BoolValue(true), evaluate("true || true"));
		
		assertEquals(new BoolValue(false), evaluate("!yes"));
		assertEquals(new BoolValue(true), evaluate("!no"));
		
		assertEquals(new BoolValue(false), evaluate("!true"));
		assertEquals(new BoolValue(true), evaluate("!false"));
	}

}
