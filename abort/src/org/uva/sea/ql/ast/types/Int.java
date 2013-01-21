package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.traversal.base.IVisitor;

/**
 * Represents the integer data type of the QL language.
 * @author J. Dijkstra
 */
public class Int extends DataType {
	/**
	 * Value of the data type
	 */
	private final int value;
	
	/**
	 * Constructor.
	 * @param value value of the data type.
	 */
	public Int(final int value) { 
		this.value = value;
	}

	/**
	 * Retrieve the value.
	 * @return value
	 */
	public int getValue() {
		return value;
	}
	
	@Override
	public void accept(final IVisitor visitor) {
		visitor.visit(this);
	}
}
