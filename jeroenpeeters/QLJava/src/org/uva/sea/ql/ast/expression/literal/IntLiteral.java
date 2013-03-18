package org.uva.sea.ql.ast.expression.literal;

import java.util.Map;

import org.uva.sea.ql.ast.expression.ExpressionVisitor;
import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.type.IntegerType;
import org.uva.sea.ql.ast.type.Type;

public class IntLiteral extends Literal {

	private final int value;

	public IntLiteral(int n) {
		this.value = n;
	}

	public int getValue() {
		return value;
	}
	
	@Override
	public Type typeOf(Map<Identifier, Type> typeEnv) {
		return new IntegerType();
	}

	public <T> T accept(final ExpressionVisitor<T> v){
		return v.visit(this);
	}
	
	@Override
	public String toString() {
		return "IntLiteral [value=" + value + "]";
	}
	
}
