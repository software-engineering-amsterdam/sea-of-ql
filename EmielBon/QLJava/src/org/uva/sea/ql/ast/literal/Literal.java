package org.uva.sea.ql.ast.literal;

import org.uva.sea.ql.ast.Expression;

/**
 * Class that represents a literal value
 * @param <T> The internal value representation of the literal
 */
public abstract class Literal<T> extends Expression {

	private final T value;
	
	public Literal(T n) {
		this.value = n;
	}

	/**
	 * Returns the internal value of this literal
	 * @return The internal value of this literal
	 */
	public T getValue() {
		return value;
	}
	
	public String getRepresentation() {
		return value.toString();
	}
	
	public String toString() {
		return getRepresentation();
	}
	
}
