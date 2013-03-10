package org.uva.sea.ql.ast.type;

public class ErrorType extends Type {

	public boolean isCompatibleWith(Type t) {
		return false;
	}
	
	public <T> T accept(TypeVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
}
