package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.Node;
import org.uva.sea.ql.visitor.ITypeVisitor;

/**
 * Represents an abstract type.
 */
abstract public class Type extends Node {
	/**
	 * Accept a visitor.
	 *
	 * @param visitor
	 */
	abstract public <T> T accept( ITypeVisitor<T> visitor );
}
