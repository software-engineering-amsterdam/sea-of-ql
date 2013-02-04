package org.uva.sea.ql.ast.types;

public class IntLiteral extends Expr{
	
	private final int value;

	public IntLiteral(String str) {
		this.value = new Integer(str);
	}

	public int getValue() {
		return value;
	}

}
