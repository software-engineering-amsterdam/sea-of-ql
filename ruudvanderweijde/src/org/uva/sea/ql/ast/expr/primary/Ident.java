package org.uva.sea.ql.ast.expr.primary;

import java.util.Map;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.type.UndefinedType;
import org.uva.sea.ql.visitor.ExpressionVisitor;


public final class Ident extends Expr {

	private final String value;

	public Ident(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
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
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
