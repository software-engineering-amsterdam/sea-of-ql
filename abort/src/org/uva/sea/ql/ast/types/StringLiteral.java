package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.traversal.base.IVisitor;


public class StringLiteral extends DataType {
	public StringLiteral(final String value) { }	
	public StringLiteral() { }

	@Override
	public void accept(final IVisitor visitor) {
		visitor.visit(this);
	}
}
