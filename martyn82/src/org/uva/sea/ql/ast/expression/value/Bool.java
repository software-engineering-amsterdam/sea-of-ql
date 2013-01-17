package org.uva.sea.ql.ast.expression.value;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.visitor.Visitor;

/**
 * Represents a boolean literal expression.
 */
public class Bool extends Literal {
	private static final Type TYPE = new org.uva.sea.ql.ast.type.Bool();
	
	/**
	 * Holds the value of the boolean literal.
	 */
	private final boolean value;

	/**
	 * Constructs a new boolean expression.
	 * 
	 * @param value The value.
	 */
	public Bool( boolean value ) {
		this.value = value;
	}
	
	/**
	 * Retrieves the value of the expression.
	 * 
	 * @return The value.
	 */
	public boolean getValue() {
		return this.value;
	}

	@Override
	public void accept( Visitor visitor ) {
		visitor.visit( this );
	}
	
	@Override
	public String toString() {
		return String.valueOf( this.value );
	}

	@Override
	public boolean checkType() {
		return true;
	}

	@Override
	public Type getType() {
		return TYPE;
	}
}
