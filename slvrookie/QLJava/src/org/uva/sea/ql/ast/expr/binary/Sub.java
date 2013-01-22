package org.uva.sea.ql.ast.expr.binary;

import java.util.Map;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.types.Numeric;
import org.uva.sea.ql.ast.types.Type;
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

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new Numeric();
	}
}
