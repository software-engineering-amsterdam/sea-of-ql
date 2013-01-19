package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.traversal.base.IVisitor;


public class StringLiteral extends DataType {
	private final String value;
	
	public StringLiteral(final String value) { this.value = value; }	

	public String getValue() {
		return value;
	}
	
	@Override
	public void accept(final IVisitor visitor) {
		visitor.visit(this);
	}	
}
