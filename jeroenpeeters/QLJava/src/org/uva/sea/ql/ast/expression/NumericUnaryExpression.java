package org.uva.sea.ql.ast.expression;

import java.util.Map;

import org.uva.sea.ql.ast.type.NumericType;
import org.uva.sea.ql.ast.type.Type;

public abstract class NumericUnaryExpression extends UnaryExpression {

	public NumericUnaryExpression(final Expression expr){
		super(expr);
	}
	
	@Override
	public Type typeOf(final Map<Identifier, Type> typeEnv) {
		return new NumericType();
	}

}
