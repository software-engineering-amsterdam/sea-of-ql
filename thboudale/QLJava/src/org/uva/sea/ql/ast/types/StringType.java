package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.visitor.ITypeVisitor;

public class StringType extends AType {

	@Override
	public boolean isCompatibleTo(AType t) {
		return t.isCompatibleToStr();
	}
	
	@Override
	public boolean isCompatibleToStr() {
		return true;
	}
	
	@Override
	public <T> T accept(ITypeVisitor<T> visitor) {
		return visitor.visit(this);
	}
}