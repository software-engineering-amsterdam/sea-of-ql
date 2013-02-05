package org.uva.sea.ql.ast.expressions.binary;


import org.uva.sea.ql.ast.eval.Env;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.values.IntValue;
import org.uva.sea.ql.ast.values.Value;

public class Sub extends Binary {

	public Sub(Expr result, Expr rhs) {
		super(result,rhs);
		allowedTypes.add(new IntType());
	}
	
	@Override
	public Value eval(Env environment) {
		return new IntValue(
				((IntValue)getLeft().eval(environment)).getValue() - 
				((IntValue)getRight().eval(environment)).getValue()
				);
	}
	
	@Override
	public Type typeOf(Env environment) {
		return new org.uva.sea.ql.ast.types.IntType();
	}
	
	@Override
	public String toString() {
		return "(" + getLeft() + " - " + getRight() + ")";
	}
}
