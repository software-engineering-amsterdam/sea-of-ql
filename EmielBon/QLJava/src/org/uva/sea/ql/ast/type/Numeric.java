package org.uva.sea.ql.ast.type;

public class Numeric extends Type {

	public boolean isCompatibleWith(Type t) {
		return t.isCompatibleWithNumeric();
	}

	public boolean isCompatibleWithInt() {
		return true;
	}
	
	public boolean isCompatibleWithMoney() {
		return true;
	}
	
	public boolean isCompatibleWithNumeric() {
		return true;
	}
	
	public <T> T accept(TypeVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
}
