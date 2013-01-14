package org.uva.sea.ql.tests.typechecker.typecheckerVisitorTests;

import org.uva.sea.ql.ast.expr.*;

interface BinaryExpressionFactory {
	public BinaryExpr createBinaryExpression(Expr left, Expr right);
}

interface UnaryExpressionFactory {
	public UnaryExpr createUnaryExpression(Expr expression);
}