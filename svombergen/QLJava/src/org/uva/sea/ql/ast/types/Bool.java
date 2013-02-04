package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.*;

public class Bool extends Expr {

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
