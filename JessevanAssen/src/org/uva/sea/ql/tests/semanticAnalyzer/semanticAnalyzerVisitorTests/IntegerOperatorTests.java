package org.uva.sea.ql.tests.semanticAnalyzer.semanticAnalyzerVisitorTests;

import org.junit.Test;
import org.uva.sea.ql.ast.expression.*;
import org.uva.sea.ql.ast.expression.value.Value;

import java.util.Arrays;
import java.util.List;

public class IntegerOperatorTests extends OperatorTests {

	// For binary operators
	private static final List<Pair<Value>> SUCCEEDING_PAIRS = Arrays.asList(
		new Pair<Value>(INT, INT));
	private static final List<Pair<Value>> FAILING_PAIRS = Arrays.asList(
		new Pair<Value>(BOOLEAN, BOOLEAN),
		new Pair<Value>(BOOLEAN, INT),
		new Pair<Value>(BOOLEAN, STRING),
		new Pair<Value>(INT,     BOOLEAN),
		new Pair<Value>(INT,     STRING),
		new Pair<Value>(STRING,  BOOLEAN),
		new Pair<Value>(STRING,  INT),
		new Pair<Value>(STRING,  STRING));
	
	// For unary operators
	private static final List<Value> SUCCEEDING_VALUES = Arrays.asList(INT);
	private static final List<Value> FAILING_VALUES    = Arrays.asList(BOOLEAN, STRING);
	
	@Test
	public void testAdd() {
		testBinaryOperator(new AddExpressionFactory(), SUCCEEDING_PAIRS, FAILING_PAIRS);
	}

	@Test
	public void testDiv() {
		testBinaryOperator(new DivExpressionFactory(), SUCCEEDING_PAIRS, FAILING_PAIRS);		
	}
	
	@Test
	public void testGEq() {
		testBinaryOperator(new GEqExpressionFactory(), SUCCEEDING_PAIRS, FAILING_PAIRS);		
	}

	@Test
	public void testGT() {
		testBinaryOperator(new GTExpressionFactory(), SUCCEEDING_PAIRS, FAILING_PAIRS);		
	}

	@Test
	public void testLEq() {
		testBinaryOperator(new LEqExpressionFactory(), SUCCEEDING_PAIRS, FAILING_PAIRS);		
	}

	@Test
	public void testLT() {
		testBinaryOperator(new LTExpressionFactory(), SUCCEEDING_PAIRS, FAILING_PAIRS);		
	}

	@Test
	public void testMul() {
		testBinaryOperator(new MulExpressionFactory(), SUCCEEDING_PAIRS, FAILING_PAIRS);	
	}

	@Test
	public void testSub() {
		testBinaryOperator(new SubExpressionFactory(), SUCCEEDING_PAIRS, FAILING_PAIRS);		
	}

	@Test
	public void testNeg() {
		testUnaryOperator(new NegExpressionFactory(), SUCCEEDING_VALUES, FAILING_VALUES);		
	}

	@Test
	public void testPos() {
		testUnaryOperator(new PosExpressionFactory(), SUCCEEDING_VALUES, FAILING_VALUES);		
	}
}

class AddExpressionFactory implements BinaryExpressionFactory {
	@Override
	public BinaryExpression createBinaryExpression(Expression left, Expression right) {
		return new Add(left, right);
	}
}
class DivExpressionFactory implements BinaryExpressionFactory {
	@Override
	public BinaryExpression createBinaryExpression(Expression left, Expression right) {
		return new Divide(left, right);
	}
}
class GEqExpressionFactory implements BinaryExpressionFactory {
	@Override
	public BinaryExpression createBinaryExpression(Expression left, Expression right) {
		return new GreaterThanOrEqualTo(left, right);
	}
}
class GTExpressionFactory implements BinaryExpressionFactory {
	@Override
	public BinaryExpression createBinaryExpression(Expression left, Expression right) {
		return new GreaterThan(left, right);
	}
}
class LEqExpressionFactory implements BinaryExpressionFactory {
	@Override
	public BinaryExpression createBinaryExpression(Expression left, Expression right) {
		return new LesserThanOrEqualTo(left, right);
	}
}
class LTExpressionFactory implements BinaryExpressionFactory {
	@Override
	public BinaryExpression createBinaryExpression(Expression left, Expression right) {
		return new LesserThan(left, right);
	}
}
class MulExpressionFactory implements BinaryExpressionFactory {
	@Override
	public BinaryExpression createBinaryExpression(Expression left, Expression right) {
		return new Multiply(left, right);
	}
}
class SubExpressionFactory implements BinaryExpressionFactory {
	@Override
	public BinaryExpression createBinaryExpression(Expression left, Expression right) {
		return new Subtract(left, right);
	}
}
class NegExpressionFactory implements UnaryExpressionFactory {
	@Override
	public UnaryExpression createUnaryExpression(Expression expression) {
		return new Negative(expression);
	}
}
class PosExpressionFactory implements UnaryExpressionFactory {

	@Override
	public UnaryExpression createUnaryExpression(Expression expression) {
		return new Positive(expression);
	}

}