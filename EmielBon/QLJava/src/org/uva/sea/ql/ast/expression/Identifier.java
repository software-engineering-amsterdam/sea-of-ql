package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.typechecker.TypeEnvironment;

public class Identifier extends Expression {

	private final String name;

	public Identifier(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public Type typeOf(TypeEnvironment env) {
		return env.getType(this);
	}
	
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	public String getRepresentation() {
		return name;
	}
	
	public boolean equals(Object other) {
		if (other instanceof Identifier) {
			return name.equals(((Identifier)other).getName());
		}
		return false;
	}
	
	public int hashCode() {
		return name.hashCode();
	}
	
	public String toString() {
		return name;
	}
	
}
