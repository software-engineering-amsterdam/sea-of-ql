package org.uva.sea.ql.ast.primaryexpr;

import org.uva.sea.ql.ast.statements.types.IntType;
import org.uva.sea.ql.ast.statements.types.Type;
import org.uva.sea.ql.visitor.IExpressionVisitor;

public class Int extends PrimaryExpr {

	private final int value;

	public Int(int n) {
		value = n;
	}
	
	@Override
	public String toString(){
		return "" + value;
	}
	
	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Type typeOf() {
		return new IntType();
	}

	public int getValue() {
		return value;
	}
	
}
