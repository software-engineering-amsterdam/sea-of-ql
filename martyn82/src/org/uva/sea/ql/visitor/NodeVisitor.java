package org.uva.sea.ql.visitor;

/**
 * Base abstract visitor.
 */
abstract public class NodeVisitor<T> {
	/**
	 * Holds the environment.
	 */
	protected Environment environment;

	/**
	 * Constructs a new NodeVisitor instance.
	 *
	 * @param environment
	 */
	protected NodeVisitor( Environment environment ) {
		this.environment = environment;
	}
}
