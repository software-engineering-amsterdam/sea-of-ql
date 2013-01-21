package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.traversal.base.IVisitor;

/**
 * Represents a string literal in the QL language.
 * @author J. Dijkstra
 */
public class StringLiteral extends DataType {
	/**
	 * Value of the data type.
	 */
	private final String value;
	
	/**
	 * Constructor.
	 * @param value value
	 */
	public StringLiteral(final String value) { 
		this.value = value;
	}	

	/**
	 * Retrieve the value of the data type.
	 * @return value
	 */
	public String getValue() {
		return value;
	}
	
	@Override
	public void accept(final IVisitor visitor) {
		visitor.visit(this);
	}	
}
