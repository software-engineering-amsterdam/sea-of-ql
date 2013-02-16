package org.uva.sea.ql.ast.types.literals;

import org.uva.sea.ql.ast.base.*;

/**
 * Representation of literals in the QL language.
 * 
 * @author J. Dijkstra
 */
public abstract class LiteralType<T> extends Expression {
	/**
	 * Constructor.
	 * 
	 * @param syntaxPosition
	 *            the original position of the expression in the input syntax
	 */
	public LiteralType(final SyntaxPosition syntaxPosition) {
		super(syntaxPosition);
	}

	/**
	 * Return the value implemented by the subclass.
	 * 
	 * @return value
	 */
	public abstract T getValue();
}
