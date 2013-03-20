package org.uva.sea.ql.ast.binaryexpr;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.visitor.IExpressionVisitor;

public class Or extends BinaryExpr {
	
	public Or(Expr result, Expr rhs) {
		super(result, rhs);
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
		return leftExpr.returnBoolValue() || rightExpr.returnBoolValue();
	}

}
