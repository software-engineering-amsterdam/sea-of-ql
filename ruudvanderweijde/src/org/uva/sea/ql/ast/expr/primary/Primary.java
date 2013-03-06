package org.uva.sea.ql.ast.expr.primary;

import org.uva.sea.ql.ast.expr.Expr;

public abstract class Primary<T> extends Expr {
	public abstract T getValue();
}