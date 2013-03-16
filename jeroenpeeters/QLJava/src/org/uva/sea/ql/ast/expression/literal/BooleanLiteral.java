package org.uva.sea.ql.ast.expression.literal;

import org.uva.sea.ql.ast.DataType;
import org.uva.sea.ql.ast.expression.ExpressionVisitor;

public class BooleanLiteral extends Literal {

	private final boolean value;

	public BooleanLiteral(boolean value) {
		super(DataType.BOOLEAN);
		this.value = value;
	}

	public boolean getValue() {
		return value;
	}

	public <T> T accept(final ExpressionVisitor<T> v){
		return v.visit(this);
	}

	@Override
	public String toString() {
		return "BooleanLiteral [value=" + value + "]";
	}
	
}
