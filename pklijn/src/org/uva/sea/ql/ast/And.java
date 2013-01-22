package org.uva.sea.ql.ast;

import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.values.BoolValue;
import org.uva.sea.ql.ast.values.Value;

public class And extends Binary {

	public And(Expr left, Expr right) {
		super(left, right);
	}

	@Override
	public Value eval() {
		return new BoolValue(
				((BoolValue)getLeft().eval()).getValue() &&
				((BoolValue)getRight().eval()).getValue()
				);
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
