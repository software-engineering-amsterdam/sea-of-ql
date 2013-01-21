package org.uva.sea.ql.ast;

import org.uva.sea.ql.interpreter.Int;
import org.uva.sea.ql.interpreter.Value;

public class Neg extends Expr {
	
	private final Expr expr;

	public Neg(Expr expr) {
		this.expr = expr;
	}

	public Expr getExpr() {
		return expr;
	}
	
	@Override
	public Value interpret() {
		return new Int(((Int)getExpr().interpret()).getVal() * -1);
	}

}
