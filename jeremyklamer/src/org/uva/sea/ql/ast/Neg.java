package org.uva.sea.ql.ast;

import org.uva.sea.ql.interpreter.Value;
import org.uva.sea.ql.interpreter.Int;

public class Neg extends Expr {
	
	private final Expr expr;

	public Neg(Expr expr) {
		this.expr = expr;
	}

	@Override
	public Value interpret() {
		return new Int(((Int)getExpr().interpret()).getVal() * -1);
	}

	public Expr getExpr() {
		return expr;
	}

}
