package org.uva.sea.ql.ast.expression;

import java.util.Map;

import org.uva.sea.ql.ast.type.BooleanType;
import org.uva.sea.ql.ast.type.Type;

public abstract class BooleanBinaryExpression extends BinaryExpression {

	public BooleanBinaryExpression(final Expression lhs, final Expression rhs){
		super(lhs, rhs);
	}
	
	@Override
	public Type typeOf(final Map<Identifier, Type> typeEnv) {
		return new BooleanType();
	}
	
	// is compatible to

}
