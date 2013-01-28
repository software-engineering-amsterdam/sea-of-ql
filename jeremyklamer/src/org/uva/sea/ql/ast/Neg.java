package org.uva.sea.ql.ast;

import java.util.Map;

import org.uva.sea.ql.ast.type.Numeric;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.interpreter.IntVal;
import org.uva.sea.ql.interpreter.Value;

public class Neg extends Unary {
	
	public Neg(Expr expr) {
		super(expr);
		permittedTypes = new Numeric();
	}
	
	@Override
	public Value interpret() {
		return new IntVal(((IntVal)getExpr().interpret()).getVal() * -1);
	}
	
	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new Numeric();
	}

}
