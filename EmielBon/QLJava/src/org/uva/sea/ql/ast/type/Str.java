package org.uva.sea.ql.ast.type;

public class Str extends Type {

	public boolean isCompatibleWith(Type t) {
		return t.isCompatibleWithStr();
	}

	public boolean isCompatibleWithStr() {
		return true;
	}
	
	public <T> T accept(TypeVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	public String toString() {
		return "string";
	}
	
}