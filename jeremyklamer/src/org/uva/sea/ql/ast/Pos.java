package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.type.Numeric;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.interpreter.Env;
import org.uva.sea.ql.interpreter.IntVal;
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
		return (IntVal) getExpr().interpret();
	}

	@Override
	public Type typeOf(Env env) {
		return new Numeric();
	}
	
}
