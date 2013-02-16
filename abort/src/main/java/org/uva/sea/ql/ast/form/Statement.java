package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.base.*;

/**
 * Represents statement (as defined in the QL language).
 * 
 * @author J. Dijkstra
 */
public abstract class Statement extends Node {
	/**
	 * Constructor.
	 * 
	 * @param syntaxPosition
	 *            position of the syntax in the original DSL input
	 */
	public Statement(final SyntaxPosition syntaxPosition) {
		super(syntaxPosition);
	}
}
