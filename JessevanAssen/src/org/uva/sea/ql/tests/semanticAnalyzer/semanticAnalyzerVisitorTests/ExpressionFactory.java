package org.uva.sea.ql.tests.semanticAnalyzer.semanticAnalyzerVisitorTests;

import org.uva.sea.ql.ast.expr.BinaryExpr;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.UnaryExpr;

interface BinaryExpressionFactory {
	public BinaryExpr createBinaryExpression(Expr left, Expr right);
}

interface UnaryExpressionFactory {
	public UnaryExpr createUnaryExpression(Expr expression);
}