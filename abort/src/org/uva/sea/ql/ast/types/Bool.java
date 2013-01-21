package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.traversal.base.IVisitor;

/**
 * Boolean data type as represented in the QL language.
 * @author J. Dijkstra
 */
public class Bool extends DataType {
	/**
	 * Value of this data type
	 */
	private final boolean value; 
	
	/**
	 * Constructor.
	 * @param value value
	 */
	public Bool(final boolean value) {
		this.value = value;
	}
	
	/**
	 * Retrieve the value of this data type.
	 * @return value
	 */
	public boolean getValue() {
		return value;
	}

	@Override
	public void accept(final IVisitor visitor) {
		visitor.visit(this);
	}
}