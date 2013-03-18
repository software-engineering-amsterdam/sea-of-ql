package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.visitor.ITypeVisitor;

public class IntType extends AType {
	
	@Override
	public boolean isCompatibleTo(AType t) {
		return t.isCompatibleToInt();
	}
	
	@Override
	public boolean isCompatibleToInt() {
		return true;
	}
	
	@Override
	public <T> T accept(ITypeVisitor<T> visitor) {
		return visitor.visit(this);
	}
}