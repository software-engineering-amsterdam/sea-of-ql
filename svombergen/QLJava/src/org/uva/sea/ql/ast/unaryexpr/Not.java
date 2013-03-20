package org.uva.sea.ql.ast.unaryexpr;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.visitor.IExpressionVisitor;

public class Not extends UnaryExpr {

	public Not(Expr result) {
		super(result);
	}
	
	@Override
	public void accept(IExpressionVisitor v) {
		v.visit(this);
	}

	@Override
	public String calculateValue() {
		return "" + this.returnBoolValue();
	}
	
	@Override
	public boolean returnBoolValue() {
		return !expression.returnBoolValue();
	}
	
}
