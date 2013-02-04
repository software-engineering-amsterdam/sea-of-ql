package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ast.Expr;

public abstract class LiteralExpr extends Expr {
	private final Object _value;
	
	protected LiteralExpr(Object value) {
		_value = value;
	}
	
	public Object getValue() {
		return _value;
	}
}