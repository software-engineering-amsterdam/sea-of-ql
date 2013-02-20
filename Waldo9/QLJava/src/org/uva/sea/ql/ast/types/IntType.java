package org.uva.sea.ql.ast.types;


public class IntType extends Type {

	@Override
	public boolean isCompatibleTo(Type type) {
		return type.isCompatibleToInt();
	}
	
	@Override
	public boolean isCompatibleToInt() {
		return true;
	}

	@Override
	public <T> T accept(TypeVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
