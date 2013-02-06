package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.Node;
import org.uva.sea.ql.visitor.StatementVisitor;

/**
 * Represents a statement.
 */
abstract public class Statement extends Node {
	/**
	 * Accept a visitor.
	 *
	 * @param visitor
	 */
	abstract public <T> T accept( StatementVisitor<T> visitor );
}
