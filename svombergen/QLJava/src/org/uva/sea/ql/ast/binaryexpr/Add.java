package org.uva.sea.ql.ast.binaryexpr;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.visitor.*;

public class Add extends BinaryExpr {	
	
	public Add(Expr result, Expr rhs) {
		super(result, rhs);
	}
	
	public void accept(IExpressionVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public String calculateValue() {
		return "" + this.returnIntValue();
	}
	
	@Override
	public int returnIntValue() {
		return leftExpr.returnIntValue() + rightExpr.returnIntValue();
	}
}
