package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.traversal.base.IVisitor;

public class Bool extends DataType {
	private final boolean value; 
	
	public Bool(final boolean value) {
		this.value = value;
	}
	
	public boolean getValue() {
		return value;
	}

	@Override
	public void accept(final IVisitor visitor) {
		visitor.visit(this);
	}
}