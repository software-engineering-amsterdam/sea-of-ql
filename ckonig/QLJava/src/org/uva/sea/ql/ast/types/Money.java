package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.ReturnsMathOperands;

public class Money extends Type implements ReturnsMathOperands {
	private Expr expr;

	public Money() {
	}

	public Money(Expr e) {
		this.expr = e;
	}

	public Expr getExpr() {
		return expr;
	}

}
