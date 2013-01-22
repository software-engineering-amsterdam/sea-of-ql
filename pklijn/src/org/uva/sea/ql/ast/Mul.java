package org.uva.sea.ql.ast;

import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.values.IntValue;
import org.uva.sea.ql.ast.values.Value;
public class Mul extends Binary {

	public Mul(Expr result, Expr rhs) {
		super(result,rhs);
	}

	@Override
	public Value eval() {
		return new IntValue(
				((IntValue)getLeft().eval()).getValue() *
				((IntValue)getRight().eval()).getValue()
				);
	}
	
	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new org.uva.sea.ql.ast.types.IntType();
	}
	
	@Override
	public List<String> checkType(List<String> errors) {
		errors = super.checkType(errors);
		
		return errors;
	}
}
