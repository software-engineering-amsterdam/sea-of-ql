package org.uva.sea.ql.ast;

import java.util.Map;

import org.uva.sea.ql.ast.type.BoolType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.interpreter.BoolVal;
import org.uva.sea.ql.interpreter.Value;

public class Or extends Binary {

	public Or(Expr left, Expr right) {
		super(left,right);
		permittedTypes = new BoolType();
	}

	@Override
	public Value interpret() {
		BoolVal lb = (BoolVal) getLeft().interpret();
		BoolVal rb = (BoolVal) getRight().interpret();
		return new BoolVal(lb.getBool() || rb.getBool());
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new BoolType();
	}

}
