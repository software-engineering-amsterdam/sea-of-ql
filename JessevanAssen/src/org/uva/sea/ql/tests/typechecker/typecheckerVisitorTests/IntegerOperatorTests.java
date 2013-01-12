package org.uva.sea.ql.tests.typechecker.typecheckerVisitorTests;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.uva.sea.ql.ast.expr.*;
import org.uva.sea.ql.ast.expr.value.Value;

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
	public BinaryExpr createBinaryExpression(Expr left, Expr right) {
		return new Add(left, right);
	}
}
class DivExpressionFactory implements BinaryExpressionFactory {
	@Override
	public BinaryExpr createBinaryExpression(Expr left, Expr right) {
		return new Div(left, right);
	}
}
class GEqExpressionFactory implements BinaryExpressionFactory {
	@Override
	public BinaryExpr createBinaryExpression(Expr left, Expr right) {
		return new GEq(left, right);
	}
}
class GTExpressionFactory implements BinaryExpressionFactory {
	@Override
	public BinaryExpr createBinaryExpression(Expr left, Expr right) {
		return new GT(left, right);
	}
}
class LEqExpressionFactory implements BinaryExpressionFactory {
	@Override
	public BinaryExpr createBinaryExpression(Expr left, Expr right) {
		return new LEq(left, right);
	}
}
class LTExpressionFactory implements BinaryExpressionFactory {
	@Override
	public BinaryExpr createBinaryExpression(Expr left, Expr right) {
		return new LT(left, right);
	}
}
class MulExpressionFactory implements BinaryExpressionFactory {
	@Override
	public BinaryExpr createBinaryExpression(Expr left, Expr right) {
		return new Mul(left, right);
	}
}
class SubExpressionFactory implements BinaryExpressionFactory {
	@Override
	public BinaryExpr createBinaryExpression(Expr left, Expr right) {
		return new Sub(left, right);
	}
}
class NegExpressionFactory implements UnaryExpressionFactory {
	@Override
	public UnaryExpr createUnaryExpression(Expr expression) {
		return new Neg(expression);
	}
}
class PosExpressionFactory implements UnaryExpressionFactory {

	@Override
	public UnaryExpr createUnaryExpression(Expr expression) {
		return new Pos(expression);
	}

}