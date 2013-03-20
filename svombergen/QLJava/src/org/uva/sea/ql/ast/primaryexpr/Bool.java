package org.uva.sea.ql.ast.primaryexpr;

import org.uva.sea.ql.visitor.IExpressionVisitor;

public class Bool extends PrimaryExpr {

	private final boolean value;

	public Bool(boolean b) {
		value = b;
	}
	
	@Override
	public boolean isBoolean() {
		return true;
	}
	
	@Override
	public String toString(){
		return calculateValue();
	}
	
	@Override
	public void accept(IExpressionVisitor v) {
		v.visit(this);
	}

	@Override
	public String calculateValue() {
		return "" + value;
	}
	
	@Override
	public boolean returnBoolValue() {
		return value;
	}

}
