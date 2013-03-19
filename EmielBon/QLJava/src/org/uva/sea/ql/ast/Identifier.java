package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.typechecker.TypeEnvironment;

/**
 * A class representing an identifier in program source code
 */
public class Identifier extends Expression {

	private final String name;

	public Identifier(String name) {
		this.name = name;
	}

	/**
	 * Get the name of this identifier
	 * @return A string containing the name of this identifier
	 */
	public String getName() {
		return name;
	}

	/**
	 * Compute the type of the value corresponding to this identifier
	 * @param env The type environment to check in
	 * @return The type of the value corresponding to this identifier
	 */
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
