package org.uva.sea.ql.ast.primaryexpr;

import org.uva.sea.ql.visitor.IExpressionVisitor;

public class Str extends PrimaryExpr {
	private final String value;

	public Str(String s) {
		value = s;
	}
	
	@Override
	public boolean isTextual() {
		return true;
	}
	
	@Override
	public void accept(IExpressionVisitor v) {
		v.visit(this);
	}

	@Override
	public String calculateValue() {
		return returnStrValue();
	}
	
	@Override
	public String returnStrValue() {
		return value;
	}
	
	@Override
	public String toString(){
		return returnStrValue();
	}
}
