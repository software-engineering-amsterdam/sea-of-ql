package org.uva.sea.ql.ast.types.literals;

import org.uva.sea.ql.ast.base.SyntaxPosition;

/**
 * Represents a numeric literal in the QL language.
 * 
 * @author J. Dijkstra
 */
public abstract class NumericLiteral extends LiteralType {
	/**
	 * Constructor.
	 * 
	 * @param syntaxPosition
	 * 			  the original position of the expression in the input syntax
	 */
	public NumericLiteral(final SyntaxPosition syntaxPosition) {
		super(syntaxPosition);
	}
}
