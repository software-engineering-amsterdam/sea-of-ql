package org.uva.sea.ql.ast.binaryexpr;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.visitor.IExpressionVisitor;

public class Sub extends BinaryExpr {

	public Sub(Expr result, Expr rhs) {
		super(result, rhs);
	}

	@Override
	public void accept(IExpressionVisitor v) {
		v.visit(this);
	}
	
	@Override
	public String calculateValue() {
		return "" + this.returnIntValue();
	}
	
	@Override
	public int returnIntValue() {
		return leftExpr.returnIntValue() - rightExpr.returnIntValue();
	}
	
}
