package org.uva.sea.ql.ast.unaryexpr;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.statements.types.BoolType;
import org.uva.sea.ql.ast.statements.types.Type;
import org.uva.sea.ql.visitor.IExpressionVisitor;

public class Not extends UnaryExpr {

	public Not(Expr result) {
		super(result);
	}
	
	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public Type typeOf() {
		return new BoolType();
	}
	
}
