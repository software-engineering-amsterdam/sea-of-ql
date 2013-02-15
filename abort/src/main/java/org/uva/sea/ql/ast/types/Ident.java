package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.base.Expression;
import org.uva.sea.ql.ast.base.SyntaxPosition;
import org.uva.sea.ql.ast.traversal.base.IVisitor;
import org.uva.sea.ql.ast.traversal.typechecking.SymbolTable;
import org.uva.sea.ql.ast.types.datatypes.DataType;

/**
 * Identifier in the QL language. Not instantiated unless a type could not be
 * identified as another type in the grammar.
 * 
 * @author J. Dijkstra
 */
public class Ident extends Expression {
	/**
	 * Name tag of the ident.
	 */
	private final String name;

	/**
	 * Constructor.
	 * 
	 * @param name
	 *            name tag
	 * @param syntaxPosition
	 * 			  the original position of the expression in the input syntax
	 */
	public Ident(final String name, final SyntaxPosition syntaxPosition) {
		super(syntaxPosition);
		this.name = name;
	}

	/**
	 * Retrieve the name tag of the ident.
	 * 
	 * @return name tag
	 */
	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		final Ident other = (Ident) obj;
		if (name == null) {
			if (other.name != null)
			{
				return false;
			}
		}
		else if (!name.equals(other.name))
		{
			return false;
		}
		return true;
	}

	@Override
	public <T> T accept(final IVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public DataType typeOf(final SymbolTable symbolTable) {
		return symbolTable.get(this);
	}
}
