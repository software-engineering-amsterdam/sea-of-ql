package org.uva.sea.ql.ast.expression;

import java.util.Map;

import org.uva.sea.ql.ast.type.BooleanType;
import org.uva.sea.ql.ast.type.Type;

public abstract class BooleanUnaryExpression extends UnaryExpression {

	public BooleanUnaryExpression(final Expression expr){
		super(expr);
	}
	
	@Override
	public Type typeOf(final Map<Identifier, Type> typeEnv) {
		return new BooleanType();
	}

}