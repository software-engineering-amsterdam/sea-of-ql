package org.uva.sea.ql.ast.binaryexpr;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.statements.types.IntType;
import org.uva.sea.ql.ast.statements.types.Type;
import org.uva.sea.ql.visitor.IExpressionVisitor;

public class Div extends BinaryExpr {
	
	public Div(Expr result, Expr rhs) {
		super(result, rhs);
	}
	
	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public Type typeOf() {
		return new IntType();
	}
	
}
