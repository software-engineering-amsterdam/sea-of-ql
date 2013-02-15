package org.uva.sea.ql.ast.types.literals;

import org.uva.sea.ql.ast.base.Expression;
import org.uva.sea.ql.ast.base.SyntaxPosition;

/**
 * Representation of literals in the QL language.
 * 
 * @author J. Dijkstra
 */
public abstract class LiteralType extends Expression {
	
	/**
	 * Constructor.
	 * 
	 * @param syntaxPosition
	 * 			  the original position of the expression in the input syntax
	 */
	public LiteralType(final SyntaxPosition syntaxPosition) {
		super(syntaxPosition);
	}
}
