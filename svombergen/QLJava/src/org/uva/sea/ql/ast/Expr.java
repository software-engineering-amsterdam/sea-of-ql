package org.uva.sea.ql.ast;

import org.uva.sea.ql.visitor.IExpressionVisitor;

public abstract class Expr {

	public abstract String calculateValue();
	public abstract void accept(IExpressionVisitor v);

	public int returnIntValue() { throw new NullPointerException(); };
	public boolean returnBoolValue() { throw new NullPointerException(); };
	public String returnStrValue() { throw new NullPointerException(); };
	
	public String getType(){
		return this.getClass().getSimpleName();
	}
	
	public boolean isNumeric() {
		return false;
	}
	
	public boolean isBoolean() {
		return false;
	}
	
	public boolean isTextual() {
		return false;
	}
}
