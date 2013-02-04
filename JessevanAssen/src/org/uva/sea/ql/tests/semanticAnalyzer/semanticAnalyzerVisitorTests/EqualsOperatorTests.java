package org.uva.sea.ql.tests.semanticAnalyzer.semanticAnalyzerVisitorTests;

import org.junit.Test;
import org.uva.sea.ql.ast.expr.BinaryExpr;
import org.uva.sea.ql.ast.expr.Eq;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.NEq;
import org.uva.sea.ql.ast.expr.value.Value;

import java.util.Arrays;
import java.util.List;

public class EqualsOperatorTests extends OperatorTests {

    private static final List<Pair<Value>> SUCCEEDING_PAIRS = Arrays.asList(
            new Pair<Value>(BOOLEAN, BOOLEAN),
            new Pair<Value>(INT,     INT),
            new Pair<Value>(STRING,  STRING));
    private static final List<Pair<Value>> FAILING_PAIRS = Arrays.asList(
            new Pair<Value>(BOOLEAN, INT),
            new Pair<Value>(BOOLEAN, STRING),
            new Pair<Value>(INT,     BOOLEAN),
            new Pair<Value>(INT,     STRING),
            new Pair<Value>(STRING,  BOOLEAN),
            new Pair<Value>(STRING,  INT));

    @Test
    public void testEquals() {
        testBinaryOperator(new EqExpressionFactory(), SUCCEEDING_PAIRS, FAILING_PAIRS);
    }

    @Test
    public void testNotEquals() {
        testBinaryOperator(new NeqExpressionFactory(), SUCCEEDING_PAIRS, FAILING_PAIRS);
    }

}

class EqExpressionFactory implements BinaryExpressionFactory {
    @Override
    public BinaryExpr createBinaryExpression(Expr left, Expr right) {
        return new Eq(left, right);
    }
}

class NeqExpressionFactory implements BinaryExpressionFactory {
    @Override
    public BinaryExpr createBinaryExpression(Expr left, Expr right) {
        return new NEq(left, right);
    }
}