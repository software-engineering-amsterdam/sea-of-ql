package org.uva.sea.ql.tests.semanticAnalyzer.semanticAnalyzerVisitorTests;

import org.uva.sea.ql.ast.expression.BinaryExpression;
import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.UnaryExpression;

interface BinaryExpressionFactory {
	public BinaryExpression createBinaryExpression(Expression left, Expression right);
}

interface UnaryExpressionFactory {
	public UnaryExpression createUnaryExpression(Expression expression);
}