package org.uva.sea.ql.ast.expr.unary;

import java.util.Map;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.types.BoolType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.IExprVisitor;

public class Not extends Unary {

	public Not(Expr leftExpr) {
		super(leftExpr);
	}

	@Override
	public <T> T accept(IExprVisitor<T> nodeVisitor) {
		return nodeVisitor.visit(this);
		
	}
	
	@Override
	public Type getExprType(Map<String, Type> typeEnv) {
		return new BoolType();
	}

}
