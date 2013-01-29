package org.uva.sea.ql.ast.expr.value;

import java.util.Map;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.type.UndefinedType;
import org.uva.sea.ql.visitor.IExpressionVisitor;


public final class Ident extends Primary<String> {

	private final String value;

	public Ident(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return "Ident";
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		if (typeEnv.containsKey(this)) {
			return typeEnv.get(this);
		}
		return new UndefinedType();
	}
	
	// Implemented "equals" and "hashCode" to be able to compare objects with the same string
	// If object are they same, but have different references, they will not be found in the hashmap.
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Ident) {
			return value.equals(((Ident) obj).value);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}

	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
