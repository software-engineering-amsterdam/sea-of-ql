package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Unary;

public class Not extends Unary {
	public Not(Expr expr) {
		super(expr);
	}
}