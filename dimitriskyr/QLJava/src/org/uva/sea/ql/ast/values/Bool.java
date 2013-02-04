package org.uva.sea.ql.ast.values;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.visitor.Visitor;

public class Bool extends Value{
	private final boolean value;
	
	public Bool( boolean value){
		this.value=value;
	}
	
	public boolean isValue() {
		return value;
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
