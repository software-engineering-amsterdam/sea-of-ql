package org.uva.sea.ql.ast.primaryexpr;

public class Int extends PrimaryExpr {

	private final int value;

	public Int(int n) {
		this.value = n;
	}

	public int getValue() {
		return value;
	}
	
	@Override
	public boolean isNumeric() {
		return true;
	}
	
	@Override
	public String toString(){
		return "" + getValue();
	}
	
}
