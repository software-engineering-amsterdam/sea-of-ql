package org.uva.sea.ql.ast.expressions.binary;


import org.uva.sea.ql.ast.eval.Env;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.values.Value;
import org.uva.sea.ql.ast.values.IntValue;


public class Add extends Binary {

	public Add(Expr left, Expr right) {
		super(left, right);
		allowedTypes.add(new IntType());
	}
	
	@Override
	public Value eval(Env environment) {
		return new IntValue(
				((IntValue)getLeft().eval(environment)).getValue() +
				((IntValue)getRight().eval(environment)).getValue()
				);
	}
	
	@Override
	public Type typeOf(Env environment) {
		return new org.uva.sea.ql.ast.types.IntType();
	}
}
