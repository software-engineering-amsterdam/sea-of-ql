package org.uva.sea.ql.ast.expression.value;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.visitor.NodeVisitor;

/**
 * Represents an integer expression.
 */
public class Int extends Number {
	private static final Type TYPE = new org.uva.sea.ql.ast.type.Int();
	
	/**
	 * Holds the integer value of the expression.
	 */
	private final int value;
	
	/**
	 * Constructs a new integer expression.
	 * 
	 * @param value The value of the expression.
	 */
	public Int( int value ) {
		this.value = value;
	}

	/**
	 * Retrieves the value of the expression.
	 * 
	 * @return The value.
	 */
	public int getValue() {
		return this.value;
	}

	@Override
	public void accept( NodeVisitor visitor ) {
		visitor.visit( this );
	}

	@Override
	public boolean checkType() {
		return true;
	}

	@Override
	public String toString() {
		return String.valueOf( this.value );
	}

	@Override
	public Type getType() {
		return TYPE;
	}
}
