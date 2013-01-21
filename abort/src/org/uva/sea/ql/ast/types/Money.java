package org.uva.sea.ql.ast.types;

import java.math.BigDecimal;

import org.uva.sea.ql.ast.traversal.base.IVisitor;

/**
 * Represents the money data type as defined in the QL language.
 * @author J. Dijkstra
 */
public class Money extends DataType {
	/**
	 * Value of the data type.
	 */
	private final BigDecimal value;	
	
	/**
	 * Constructor.
	 * @param value value of the data type.
	 */
	public Money(final String value) {
		this.value = new BigDecimal(value);
	}
	
	/**
	 * Retrieve the value of the data type.
	 * @return value
	 */
	public BigDecimal getValue() {
		return value;
	}

	@Override
	public void accept(final IVisitor visitor) {
		visitor.visit(this);
	}
}
