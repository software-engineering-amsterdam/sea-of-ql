package org.uva.sea.ql.ast;

import org.uva.sea.ql.interpreter.Value;
import org.uva.sea.ql.interpreter.Int;

public class Pos extends Expr {

	private final Expr expr;
	
	public Pos(Expr expr) {
		this.expr = expr;
	}

	@Override
	public Value interpret() {
		return (Int) getExpr().interpret();
	}

	public Expr getExpr() {
		return expr;
	}

}
