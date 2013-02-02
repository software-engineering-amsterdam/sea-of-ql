package org.uva.sea.ql.ast.values;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.visitor.Visitor;

public class Int extends Value {
	private final int value;
	
	public Int (int value){
		this.value=value;
	}
	
	public int getValue() {
		return value;
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
