package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.*;

public class Bool extends Type{
	private final boolean value;

	public Bool( boolean value){
		this.value=value;
	}

	public boolean isValue() {
		return value;
	}

}