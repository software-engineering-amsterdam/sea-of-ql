package org.uva.sea.ql.ast.expressions.binary;

import org.uva.sea.ql.ast.expressions.Expr;


public abstract class BinaryExpr extends Expr {
	private final Expr _lhs, _rhs;
	
	protected BinaryExpr(Expr lhs, Expr rhs) {
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