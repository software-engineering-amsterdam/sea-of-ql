package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.DataType;
import org.uva.sea.ql.ast.INode;

/**
 * Represents a type value.
 */
abstract public class Type implements INode {
	/**
	 * Holds the datatype.
	 */
	private final DataType type;

	/**
	 * Constructs a new Type instance.
	 *
	 * @param type
	 */
	public Type( DataType type ) {
		this.type = type;
	}

	/**
	 * Retrieves the data type.
	 *
	 * @return The data type.
	 */
	public DataType getType() {
		return this.type;
	}
}
