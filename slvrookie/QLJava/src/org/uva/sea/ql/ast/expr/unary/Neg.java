package org.uva.sea.ql.ast.expr.unary;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.visitor.Context;
import org.uva.sea.ql.visitor.Visitor;

public class Neg extends UnaryExpr {

	public Neg(Expr arg) {
		super(arg);
	}

	@Override
	public void accept(Visitor visitor, Context context) {
		visitor.visit(this, context);
	}
	
}
