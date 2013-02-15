package org.uva.sea.ql.ast.types.literals;

import org.uva.sea.ql.ast.base.SyntaxPosition;
import org.uva.sea.ql.ast.traversal.base.IVisitor;
import org.uva.sea.ql.ast.traversal.typechecking.SymbolTable;
import org.uva.sea.ql.ast.types.datatypes.DataType;
import org.uva.sea.ql.ast.types.datatypes.IntType;

/**
 * Represents the integer literal of the QL language.
 * 
 * @author J. Dijkstra
 */
public class IntLiteral extends NumericLiteral {
	private static final DataType TYPE = new IntType();

	/**
	 * Value of the data type
	 */
	private final int value;

	/**
	 * Constructor.
	 * 
	 * @param value
	 *            value of the data type.
	 * @param syntaxPosition
	 * 			  the original position of the expression in the input syntax
	 */
	public IntLiteral(final int value, final SyntaxPosition syntaxPosition) {
		super(syntaxPosition);
		this.value = value;
	}

	/**
	 * Retrieve the value.
	 * 
	 * @return value
	 */
	public int getValue() {
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
