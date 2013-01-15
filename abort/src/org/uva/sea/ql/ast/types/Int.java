package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.traversal.base.IVisitor;

public class Int extends DataType {


	public Int(final int value) {
	}
	
	public Int() { }

	@Override
	public void accept(final IVisitor visitor) {
		visitor.visit(this);
	}
}
