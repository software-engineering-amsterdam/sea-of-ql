package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.interfaces.ReturnsMathOperands;

public class Money extends Type implements ReturnsMathOperands {
	private Expr expr;

	public Money() {
	}

	public Money(Expr e) {
		this.expr = e;
	}

	public final Expr getExpr() {
		return this.expr;
	}

}
