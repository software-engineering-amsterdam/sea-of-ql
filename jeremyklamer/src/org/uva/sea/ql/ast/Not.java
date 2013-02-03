package org.uva.sea.ql.ast;

import java.util.Map;

import org.uva.sea.ql.ast.type.BoolType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.interpreter.BoolVal;
import org.uva.sea.ql.interpreter.Value;

public class Not extends Unary {
	
	public Not(Expr expr) {
		super(expr);
		permittedTypes = new BoolType();
	}
	
	@Override
	public Value interpret() {
		return new BoolVal(!((BoolVal)getExpr().interpret()).getBool());
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new BoolType();
	}
	
}
