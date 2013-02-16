package org.uva.sea.ql.ast.base;

import org.uva.sea.ql.ast.traversal.base.IVisitable;

/**
 * Represents a node in the abstract syntax tree.
 * 
 * @author J. Dijkstra
 */
public abstract class Node implements IVisitable {
	/**
	 * Syntax Position information to use later in type checking or referring to the original DSL input syntax.
	 */
	private final SyntaxPosition syntaxPosition;

	/**
	 * Constructor.
	 * 
	 * @param position
	 *            syntax position in the original DSL input
	 */
	protected Node(final SyntaxPosition position) {
		this.syntaxPosition = position;
	}

	/**
	 * Retrieve the original syntax position (the position from the original input syntax).
	 * 
	 * @return syntax position
	 */
	public SyntaxPosition getSyntaxPosition() {
		return syntaxPosition;
	}
}
