package org.uva.sea.ql.ast.unaryexpr;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.visitor.IExpressionVisitor;

public class Pos extends UnaryExpr {

	public Pos(Expr result) {
		super(result);
	}
	
	@Override
	public void accept(IExpressionVisitor v) {
		v.visit(this);
	}

	@Override
	public String calculateValue() {
		return "" + returnIntValue();
	}
	
	@Override
	public int returnIntValue() {
		return expression.returnIntValue();
	}

}
