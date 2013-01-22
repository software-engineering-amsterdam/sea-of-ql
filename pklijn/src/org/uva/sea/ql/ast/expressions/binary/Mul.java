package org.uva.sea.ql.ast.expressions.binary;

import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.expressions.Ident;
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
	
	@Override // TODO: String > message /error..
	public List<String> checkType(List<String> errors) {
		errors = super.checkType(errors);
		
		return errors;
	}
}
