package org.uva.sea.ql.ast.expr.unary;

import java.util.Map;

import org.uva.sea.ql.ast.expr.*;
import org.uva.sea.ql.ast.types.Numeric;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.IVisitor;

public class Neg extends UnaryExpr {

	public Neg(Expr arg) {
		super(arg);
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new Numeric();
	}

	@Override
	public <T> T accept(IVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
}
