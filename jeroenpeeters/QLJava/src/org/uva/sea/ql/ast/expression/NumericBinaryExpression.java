package org.uva.sea.ql.ast.expression;

import java.util.Map;

import org.uva.sea.ql.ast.type.NumericType;
import org.uva.sea.ql.ast.type.Type;

public abstract class NumericBinaryExpression extends BinaryExpression {

	public NumericBinaryExpression(final Expression lhs, final Expression rhs){
		super(lhs, rhs);
	}
	
	@Override
	public Type typeOf(final Map<Identifier, Type> typeEnv) {
		return new NumericType();
	}

}
