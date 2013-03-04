package org.uva.sea.ql.ast.primaryexpr;

public class Bool extends PrimaryExpr {

	private final boolean value;

	public Bool(boolean b) {
		this.value = b;
	}

	public boolean getValue() {
		return value;
	}
	
	@Override
	public String toString(){
		return "" + getValue();
	}

}
