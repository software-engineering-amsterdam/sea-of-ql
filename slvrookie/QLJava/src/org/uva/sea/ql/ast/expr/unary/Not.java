package org.uva.sea.ql.ast.expr.unary;

import java.util.Map;

import org.uva.sea.ql.ast.expr.*;
import org.uva.sea.ql.ast.types.BoolType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.IVisitor;

public class Not extends UnaryExpr {

	public Not(Expr arg) {
		super(arg);
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new BoolType();
	}

	@Override
	public <T> T accept(IVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
}
