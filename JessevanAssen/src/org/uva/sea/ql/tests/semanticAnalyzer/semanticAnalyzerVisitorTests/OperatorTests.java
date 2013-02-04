package org.uva.sea.ql.tests.semanticAnalyzer.semanticAnalyzerVisitorTests;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.value.Bool;
import org.uva.sea.ql.ast.expr.value.Int;
import org.uva.sea.ql.ast.expr.value.Str;
import org.uva.sea.ql.ast.expr.value.Value;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class OperatorTests extends SemanticAnalyzerVisitorTests {
	
	protected static final Value BOOLEAN = new Bool(true),
                                 INT     = new Int(10),
                                 STRING  = new Str("abc");
	
	protected void testUnaryOperator(
			UnaryExpressionFactory unaryExpressionFactory,
			List<Value> succeedingValues,
			List<Value> failingValues) {
		for(Value value : succeedingValues) {
			Expr validExpression = unaryExpressionFactory.createUnaryExpression(value);
			validExpression.accept(visitor, context);
            assertTrue(context.getErrors().isEmpty());
		}

        int numberOfErrors = 0;
		for(Value value : failingValues) {
            Expr failingExpression = unaryExpressionFactory.createUnaryExpression(value);
            failingExpression.accept(visitor, context);

            assertTrue(context.getErrors().size() > numberOfErrors);
            numberOfErrors = context.getErrors().size();
		}	
	}
	
	protected void testBinaryOperator(
			BinaryExpressionFactory binaryExpressionFactory,
			List<Pair<Value>> succeedingPairs,
			List<Pair<Value>> failingPairs) {
		for(Pair<Value> pair : succeedingPairs) {
			Expr validExpression = binaryExpressionFactory.createBinaryExpression(pair.getLeft(), pair.getRight());
			validExpression.accept(visitor, context);
            assertTrue(context.getErrors().isEmpty());
		}

        int numberOfErrors = 0;
		for(Pair<Value> pair : failingPairs) {
            Expr failingExpression = binaryExpressionFactory.createBinaryExpression(pair.getLeft(), pair.getRight());
            failingExpression.accept(visitor, context);

            assertTrue(context.getErrors().size() > numberOfErrors);
            numberOfErrors = context.getErrors().size();
		}		
	}
	
}
