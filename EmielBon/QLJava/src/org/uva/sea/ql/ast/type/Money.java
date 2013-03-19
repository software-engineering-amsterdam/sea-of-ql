package org.uva.sea.ql.ast.type;

public class Money extends Numeric {

	public boolean isCompatibleWith(Type t) {
		return t.isCompatibleWithMoney();
	}
	
	public <T> T accept(TypeVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public String toString() {
		return "money";
	}
	
}
