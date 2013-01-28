package org.uva.sea.ql.ast;

public abstract class Binary extends Expr {
	private final Expr _lhs, _rhs;
	
	protected Binary(Expr lhs, Expr rhs) {
		_lhs = lhs;
		_rhs = rhs;
	}
	
	public Expr getLhs() {
		return _lhs;
	}
	
	public Expr getRhs() {
		return _rhs;
	}
}