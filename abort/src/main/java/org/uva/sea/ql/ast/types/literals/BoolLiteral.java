package org.uva.sea.ql.ast.types.literals;

import org.uva.sea.ql.ast.base.SyntaxPosition;
import org.uva.sea.ql.ast.traversal.base.IVisitor;
import org.uva.sea.ql.ast.traversal.typechecking.SymbolTable;
import org.uva.sea.ql.ast.types.datatypes.*;

/**
 * Boolean literal as represented in the QL language.
 * 
 * @author J. Dijkstra
 */
public class BoolLiteral extends LiteralType<Boolean> {
	private static final DataType TYPE = new BoolType();

	/**
	 * Value of this data type
	 */
	private final boolean value;

	/**
	 * Constructor.
	 * 
	 * @param value
	 *            value
	 * @param syntaxPosition
	 *            the original position of the expression in the input syntax
	 */
	public BoolLiteral(final boolean value, final SyntaxPosition syntaxPosition) {
		super(syntaxPosition);
		this.value = value;
	}

	/**
	 * Retrieve the value of this data type.
	 * 
	 * @return value
	 */
	@Override
	public Boolean getValue() {
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