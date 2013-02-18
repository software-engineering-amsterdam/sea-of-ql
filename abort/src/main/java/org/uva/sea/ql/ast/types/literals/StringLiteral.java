package org.uva.sea.ql.ast.types.literals;

import org.uva.sea.ql.ast.base.SyntaxPosition;
import org.uva.sea.ql.ast.traversal.base.IVisitor;
import org.uva.sea.ql.ast.traversal.typechecking.SymbolTable;
import org.uva.sea.ql.ast.types.datatypes.*;

/**
 * Represents a string literal in the QL language.
 * 
 * @author J. Dijkstra
 */
public class StringLiteral extends Literal<String> {
	private static final DataType TYPE = new StringType();

	/**
	 * Value of the data type.
	 */
	private final String value;

	/**
	 * Constructor.
	 * 
	 * @param value
	 *            value
	 * @param syntaxPosition
	 *            the original position of the expression in the input syntax
	 */
	public StringLiteral(final String value, final SyntaxPosition syntaxPosition) {
		super(syntaxPosition);
		this.value = value;
	}

	@Override
	public String getValue() {
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
