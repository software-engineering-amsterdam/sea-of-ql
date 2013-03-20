package org.uva.sea.ql.ast.primaryexpr;

import org.uva.sea.ql.visitor.IExpressionVisitor;

public class Int extends PrimaryExpr {

	private final int value;

	public Int(int n) {
		value = n;
	}
	
	@Override
	public boolean isNumeric() {
		return true;
	}
	
	@Override
	public String toString(){
		return "" + value;
	}
	
	@Override
	public void accept(IExpressionVisitor v) {
		v.visit(this);
	}

	@Override
	public String calculateValue() {
		return toString();
	}
	
	@Override
	public int returnIntValue() {
		return value;
	}
	
}
