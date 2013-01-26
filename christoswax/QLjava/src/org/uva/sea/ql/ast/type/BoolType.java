package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.*;

public class BoolType extends Type{
	private final boolean value;

	public BoolType(boolean value){
		this.value=value;
	}
}
