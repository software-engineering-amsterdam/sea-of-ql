package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.*;

public class Int extends Type {
	private final int value;
	
	public Int (int value){
		this.value=value;
	}
	
	public int getValue() {
		return value;
	}

}
