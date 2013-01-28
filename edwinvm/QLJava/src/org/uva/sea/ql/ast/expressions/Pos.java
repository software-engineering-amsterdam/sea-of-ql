package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Unary;

public class Pos extends Unary {
	public Pos(Expr expr) {
		super(expr);
	}
}