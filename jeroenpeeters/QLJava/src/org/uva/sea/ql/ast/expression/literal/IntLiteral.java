package org.uva.sea.ql.ast.expression.literal;

import org.uva.sea.ql.ast.DataType;
import org.uva.sea.ql.ast.expression.ExpressionVisitor;

public class IntLiteral extends Literal {

	private final int value;

	public IntLiteral(int n) {
		super(DataType.INTEGER);
		this.value = n;
	}

	public int getValue() {
		return value;
	}

	public <T> T accept(final ExpressionVisitor<T> v){
		return v.visit(this);
	}
	
	@Override
	public String toString() {
		return "IntLiteral [value=" + value + "]";
	}
	
}
