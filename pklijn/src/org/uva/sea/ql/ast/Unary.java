package org.uva.sea.ql.ast;

import java.util.Map;

import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.values.Value;

public class Unary extends Expr {
	private Expr arg;
	
	public Unary(Expr arg) {
		this.arg = arg;
	}
	
	public Expr getArg() {
		return arg;
	}

	@Override
	public Value eval() {
		throw new UnsupportedOperationException("Can't get a value from a Unary class");
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		// TODO Auto-generated method stub
		return null;
	}

}
