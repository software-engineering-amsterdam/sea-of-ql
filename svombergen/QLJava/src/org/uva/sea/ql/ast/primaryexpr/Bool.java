package org.uva.sea.ql.ast.primaryexpr;

import org.uva.sea.ql.ast.statements.types.BoolType;
import org.uva.sea.ql.ast.statements.types.Type;
import org.uva.sea.ql.visitor.IExpressionVisitor;

public class Bool extends PrimaryExpr {

	private final boolean value;

	public Bool(boolean b) {
		value = b;
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
		return new BoolType();
	}
	
	public boolean getValue() {
		return value;
	}

}
