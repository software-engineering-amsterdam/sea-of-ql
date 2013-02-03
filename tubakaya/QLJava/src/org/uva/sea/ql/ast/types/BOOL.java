package org.uva.sea.ql.ast.types;

public class BOOL extends Expr {

	private final Boolean value;

	public BOOL(Boolean n) {
		this.value = n;
	}

	public Boolean getValue() {
		return value;
	}
	
}
