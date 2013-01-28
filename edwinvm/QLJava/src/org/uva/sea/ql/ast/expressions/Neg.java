package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Unary;

public class Neg extends Unary {
	public Neg(Expr expr) {
		super(expr);
	}
}