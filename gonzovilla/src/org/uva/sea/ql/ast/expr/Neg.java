package org.uva.sea.ql.ast.expr;

import java.util.Map;

import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.types.TypeInt;

public class Neg extends Unary {

	public Neg(Expr x) {
		super(x);
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new TypeInt();
	}

}
