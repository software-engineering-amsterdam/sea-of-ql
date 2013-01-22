package org.uva.sea.ql.ast.expressions.binary;

import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.values.*;

public class Eq extends Binary {

	public Eq(Expr left, Expr right) {
		super(left, right);
	}

	@Override
	public Value eval() {
		return new org.uva.sea.ql.ast.values.BoolValue(getLeft().eval().equals(getRight().eval()));
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new org.uva.sea.ql.ast.types.BoolType();
	}
	
	@Override
	public List<String> checkType(List<String> errors) {
		errors = super.checkType(errors);
		
		return errors;
	}

}
