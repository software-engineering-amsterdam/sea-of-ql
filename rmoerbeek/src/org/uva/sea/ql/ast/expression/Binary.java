package org.uva.sea.ql.ast.expression;

import java.util.Map;

import org.uva.sea.ql.ast.types.Type;

public abstract class Binary extends Expr {
	private final Expr lhs;
	private final Expr rhs;

	protected Binary(Expr lhs, Expr rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}

	public Expr getLhs() {
		return lhs;
	}

	public Expr getRhs() {
		return rhs;
	}

	public abstract Type typeOf(Map<Ident, Type> typeEnv);
	
	

}