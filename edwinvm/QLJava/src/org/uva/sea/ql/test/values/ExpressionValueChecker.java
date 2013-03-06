package org.uva.sea.ql.test.values;

import static org.junit.Assert.assertEquals;

import org.uva.sea.ql.ast.expressions.Expression;
import org.uva.sea.ql.ast.values.Value;
import org.uva.sea.ql.check.ValueEnvironment;
import org.uva.sea.ql.check.values.Evaluator;
import org.uva.sea.ql.parser.antlr.check.ANTLRParserExpressions;
import org.uva.sea.ql.parser.errors.ParseError;

public class ExpressionValueChecker {
	
	private final ValueEnvironment _valueEnvironment;
	
	public ExpressionValueChecker() {
		_valueEnvironment = new ValueEnvironment();
	}
	
	public void expressionMatchesValue(String input, String result) throws ParseError { assertEquals(computeValue(input), computeValue(result)); }
	
	public void expressionMatchesValue(Value input, Value result)                     { assertEquals(input, result); }
	
	private Value computeValue(String input)           throws ParseError { return evaluateExpression(input); }
	
	private Value evaluateExpression(String input)     throws ParseError { return getValueFor(parseExpression(input)); }
	
	private Value getValueFor(Expression expression) { return Evaluator.evaluate(expression, _valueEnvironment); }
	
	private Expression parseExpression(String input)   throws ParseError { return new ANTLRParserExpressions().parse(input); }
	
}