package org.uva.sea.ql.ast.unaryexpr;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.visitor.IExpressionVisitor;

public class Neg extends UnaryExpr {

	public Neg(Expr result) {
		super(result);
	}
	
	@Override
	public void accept(IExpressionVisitor v) {
		v.visit(this);
	}

	@Override
	public String calculateValue() {
		return "" + returnBoolValue();
	}
	
	@Override
	public boolean returnBoolValue() {
		return !expression.returnBoolValue();
	}

}
