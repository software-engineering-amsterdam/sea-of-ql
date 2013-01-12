package org.uva.sea.ql.tests.typechecker.typecheckerVisitorTests;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.uva.sea.ql.ast.expr.*;
import org.uva.sea.ql.ast.expr.value.*;

public class BooleanOperatorTests extends OperatorTests {
	
	private static final List<Pair<Value>> SUCCEEDING_PAIRS = Arrays.asList(
		new Pair<Value>(BOOLEAN, BOOLEAN));
	private static final List<Pair<Value>> FAILING_PAIRS = Arrays.asList(
		new Pair<Value>(BOOLEAN, INT),
		new Pair<Value>(BOOLEAN, STRING),
		new Pair<Value>(INT,     BOOLEAN),
		new Pair<Value>(INT,     INT),
		new Pair<Value>(INT,     STRING),
		new Pair<Value>(STRING,  BOOLEAN),
		new Pair<Value>(STRING,  INT),
		new Pair<Value>(STRING,  STRING));
	
	@Test
	public void testAnd() { 
		testBinaryOperator(new AndExpressionFactory(), SUCCEEDING_PAIRS, FAILING_PAIRS); 
	}
	
	@Test
	public void testOr() { 
		testBinaryOperator(new OrExpressionFactory(), SUCCEEDING_PAIRS, FAILING_PAIRS);
	}
	
	@Test
	public void testNot() {
		testUnaryOperator(
				new NotExpressionFactory(),
				Arrays.asList(BOOLEAN),
				Arrays.asList(INT, STRING));
	}
}

class AndExpressionFactory implements BinaryExpressionFactory {
	@Override
	public BinaryExpr createBinaryExpression(Expr left, Expr right) {
		return new And(left, right);
	}
}

class OrExpressionFactory implements BinaryExpressionFactory {
	@Override
	public BinaryExpr createBinaryExpression(Expr left, Expr right) {
		return new Or(left, right);
	}
}

class NotExpressionFactory implements UnaryExpressionFactory {
	@Override
	public UnaryExpr createUnaryExpression(Expr expression) {
		return new Not(expression);
	}
	
}
