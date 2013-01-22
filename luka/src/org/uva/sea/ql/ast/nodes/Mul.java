package org.uva.sea.ql.ast.nodes;

import java.util.Map;

import org.uva.sea.ql.ast.type.Type;

public class Mul extends BinaryExpr {

	private final Expr lhs;
	private final Expr rhs;

	public Mul(Expr lhs, Expr rhs) {
		super(lhs,rhs);
		this.lhs = lhs;
		this.rhs = rhs;
	}

	public Expr getLhs() {
		return lhs;
	}

	public Expr getRhs() {
		return rhs;
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		// TODO Auto-generated method stub
		return null;
	}
}
