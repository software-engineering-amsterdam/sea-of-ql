package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.traversal.base.IVisitor;

public class Bool extends DataType {
	private boolean value; 
	
	public Bool() { }
	
	public Bool(final boolean value) {
		this.value = value;
	}
	
	public Object getValue() {
		return value;
	}

	@Override
	public void accept(final IVisitor visitor) {
		visitor.visit(this);
	}
}