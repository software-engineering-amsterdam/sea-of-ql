package org.uva.sea.ql.ast.type;

public class Bool extends Type {

	public boolean isCompatibleWith(Type t) {
		return t.isCompatibleWithBool();
	}

	public boolean isCompatibleWithBool() {
		return true;
	}
	
	public <T> T accept(TypeVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
}
