package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.traversal.base.IVisitor;

public class Int extends DataType {
	private final int value;
	
	public Int(final int value) { 
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	
	@Override
	public void accept(final IVisitor visitor) {
		visitor.visit(this);
	}
}
