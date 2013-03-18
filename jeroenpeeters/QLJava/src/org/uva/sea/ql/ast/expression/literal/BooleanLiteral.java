package org.uva.sea.ql.ast.expression.literal;

import java.util.Map;

import org.uva.sea.ql.ast.expression.ExpressionVisitor;
import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.type.BooleanType;
import org.uva.sea.ql.ast.type.Type;

public class BooleanLiteral extends Literal {

	private final boolean value;

	public BooleanLiteral(boolean value) {
		this.value = value;
	}

	public boolean getValue() {
		return value;
	}

	public <T> T accept(final ExpressionVisitor<T> v){
		return v.visit(this);
	}

	@Override
	public Type typeOf(Map<Identifier, Type> typeEnv) {
		return new BooleanType();
	}

	@Override
	public String toString() {
		return "BooleanLiteral [value=" + value + "]";
	}
	
}
