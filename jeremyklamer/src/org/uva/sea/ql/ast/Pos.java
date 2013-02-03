package org.uva.sea.ql.ast;

import java.util.Map;

import org.uva.sea.ql.ast.type.Numeric;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.interpreter.IntVal;
import org.uva.sea.ql.interpreter.Value;

public class Pos extends Unary {
	
	public Pos(Expr expr) {
		super(expr);
		permittedTypes = new Numeric();
	}
	
	@Override
	public Value interpret() {
		return (IntVal) getExpr().interpret();
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new Numeric();
	}
	
}
