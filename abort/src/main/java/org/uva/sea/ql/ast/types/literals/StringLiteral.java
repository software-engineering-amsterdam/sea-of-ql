package org.uva.sea.ql.ast.types.literals;

import org.uva.sea.ql.ast.traversal.SymbolTable;
import org.uva.sea.ql.ast.traversal.base.IVisitor;
import org.uva.sea.ql.ast.types.datatypes.DataType;
import org.uva.sea.ql.ast.types.datatypes.StringType;

/**
 * Represents a string literal in the QL language.
 * 
 * @author J. Dijkstra
 */
public class StringLiteral extends LiteralType {
	private static final DataType type = new StringType();

	/**
	 * Value of the data type.
	 */
	private final String value;

	/**
	 * Constructor.
	 * 
	 * @param value
	 *            value
	 */
	public StringLiteral(final String value) {
		this.value = value;
	}

	/**
	 * Retrieve the value of the data type.
	 * 
	 * @return value
	 */
	public String getValue() {
		return value;
	}

	@Override
	public <T> T accept(final IVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public DataType typeOf(final SymbolTable symbolTable) {
		return type;
	}
}
