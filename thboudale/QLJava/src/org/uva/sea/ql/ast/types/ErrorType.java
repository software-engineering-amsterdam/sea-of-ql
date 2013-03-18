package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.visitor.ITypeVisitor;

public class ErrorType extends AType {
	
	@Override
	public boolean isCompatibleTo(AType t) {
		return false;
	}
	
	@Override
	public <T> T accept(ITypeVisitor<T> visitor) {
		return visitor.visit(this);
	}
}