package org.uva.sea.ql.ast.expr.binary;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.visitor.Context;
import org.uva.sea.ql.visitor.Visitor;

public class Sub extends BinaryExpr {

	public Sub(Expr result, Expr rhs) {
		super(result, rhs);
	}

	@Override
	public void accept(Visitor visitor, Context context) {
		visitor.visit(this, context);
	}

}
