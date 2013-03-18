package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.visitor.ITypeVisitor;

public class BoolType extends AType {
	
	@Override
	public boolean isCompatibleTo(AType t) {
		return t.isCompatibleToBool();
	}
	
	@Override
	public boolean isCompatibleToBool() {
		return true;
	}
	
	@Override
	public <T> T accept(ITypeVisitor<T> visitor) {
		return visitor.visit(this);
	}
}