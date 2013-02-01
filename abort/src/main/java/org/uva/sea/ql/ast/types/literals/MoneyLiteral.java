package org.uva.sea.ql.ast.types.literals;

import java.math.BigDecimal;

import org.uva.sea.ql.ast.traversal.SymbolTable;
import org.uva.sea.ql.ast.traversal.base.IVisitor;
import org.uva.sea.ql.ast.types.datatypes.DataType;
import org.uva.sea.ql.ast.types.datatypes.MoneyType;

/**
 * Represents the money literal as defined in the QL language.
 * 
 * @author J. Dijkstra
 */
public class MoneyLiteral extends NumericLiteral {
	private static final DataType TYPE = new MoneyType();

	/**
	 * Value of the data type.
	 */
	private final BigDecimal value;

	/**
	 * Constructor.
	 * 
	 * @param value
	 *            value of the data type.
	 */
	public MoneyLiteral(final String value) {
		this.value = new BigDecimal(value);
	}

	/**
	 * Retrieve the value of the data type.
	 * 
	 * @return value
	 */
	public BigDecimal getValue() {
		return value;
	}

	@Override
	public <T> T accept(final IVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public DataType typeOf(final SymbolTable symbolTable) {
		return TYPE;
	}
}
