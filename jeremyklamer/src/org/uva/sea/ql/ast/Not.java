package org.uva.sea.ql.ast;

import org.uva.sea.ql.interpreter.BoolType;
import org.uva.sea.ql.interpreter.Value;

public class Not extends Expr {

	private final Expr expr;
	
	public Not(Expr expr) {
		this.expr = expr;
	}

	@Override
	public Value interpret() {
		return new BoolType(!((BoolType)getExpr().interpret()).getBool());
	}

	public Expr getExpr() {
		return expr;
	}

}
