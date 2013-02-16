package org.uva.sea.ql.ast.expr.binary.algebraic;

import java.util.Map;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.types.NumericType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.IExprVisitor;

public class Div extends Algebraic{

	public Div(Expr leftExpr, Expr rightExpr) {
		super(leftExpr,rightExpr);
	}

	@Override
	public <T> T accept(IExprVisitor<T> nodeVisitor) {
		return nodeVisitor.visit(this);
		
	}

	@Override
	public Type getExprType(Map<String, Type> typeEnv) {
		return new NumericType();
	}

}
