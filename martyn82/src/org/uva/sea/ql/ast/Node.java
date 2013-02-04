package org.uva.sea.ql.ast;

/**
 * Represents a node in an AST.
 */
abstract public class Node {
	@Override
	public String toString() {
		return this.getClass().getSimpleName().toUpperCase();
	}
}
