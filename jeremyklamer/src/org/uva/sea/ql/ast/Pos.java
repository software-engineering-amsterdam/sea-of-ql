package org.uva.sea.ql.ast;

import org.uva.sea.ql.interpreter.Int;
import org.uva.sea.ql.interpreter.Value;

public class Pos extends Expr {

	private final Expr expr;
	
	public Pos(Expr expr) {
		this.expr = expr;
	}

	public Expr getExpr() {
		return expr;
	}
	
	@Override
	public Value interpret() {
		return (Int) getExpr().interpret();
	}

}
