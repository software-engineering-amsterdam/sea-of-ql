package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.interpreter.Context;
import org.uva.sea.ql.interpreter.Value;

/**
 * Represents an integer expression.
 */
public class Int extends Expression {
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
		return value;
	}

	@Override
	public Value eval( Context context ) {
		// TODO Auto-generated method stub
		return null;
	}
}
