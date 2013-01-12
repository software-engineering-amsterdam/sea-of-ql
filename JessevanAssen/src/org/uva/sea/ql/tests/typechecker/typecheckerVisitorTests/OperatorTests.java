package org.uva.sea.ql.tests.typechecker.typecheckerVisitorTests;

import static org.junit.Assert.*;

import java.util.List;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.value.Bool;
import org.uva.sea.ql.ast.expr.value.Int;
import org.uva.sea.ql.ast.expr.value.Str;
import org.uva.sea.ql.ast.expr.value.Value;
import org.uva.sea.ql.typechecker.TypecheckerException;

public class OperatorTests extends TypecheckerVisitorTests {
	
	protected static final Value BOOLEAN = new Bool(true),
                                 INT     = new Int(10),
                                 STRING  = new Str("abc");
	
	protected void testUnaryOperator(
			UnaryExpressionFactory unaryExpressionFactory,
			List<Value> succeedingValues,
			List<Value> failingValues) {
		for(Value value : succeedingValues) {
			Expr validExpression = unaryExpressionFactory.createUnaryExpression(value);
			validExpression.accept(visitor, symbolTable);
		}
		
		for(Value value : failingValues) {
			try {
				Expr failingExpression = unaryExpressionFactory.createUnaryExpression(value);
				failingExpression.accept(visitor, symbolTable);
				// An exception should have been thrown at this point, so the test failed if this code is reached.
				fail();
			} catch(TypecheckerException x) {
				// The test actually succeeds if this exception occurs
			} catch(Exception x) {
				// Other exception, shouldn't occur
				fail();
			}
		}	
	}
	
	protected void testBinaryOperator(
			BinaryExpressionFactory binaryExpressionFactory,
			List<Pair<Value>> succeedingPairs,
			List<Pair<Value>> failingPairs) {
		for(Pair<Value> pair : succeedingPairs) {
			Expr validExpression = binaryExpressionFactory.createBinaryExpression(pair.getLeft(), pair.getRight());
			validExpression.accept(visitor, symbolTable);
		}
		
		for(Pair<Value> pair : failingPairs) {
			try {
				Expr failingExpression = binaryExpressionFactory.createBinaryExpression(pair.getLeft(), pair.getRight());
				failingExpression.accept(visitor, symbolTable);
				// An exception should have been thrown at this point, so the test failed if this code is reached.
				fail();
			} catch(TypecheckerException x) {
				// The test actually succeeds if this exception occurs
			} catch(Exception x) {
				// Other exception, shouldn't occur
				fail();
			}
		}		
	}
	
}
