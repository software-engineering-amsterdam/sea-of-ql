package org.uva.sea.ql.visitor;

import org.uva.sea.ql.eval.Environment;

/**
 * Combined visitor interface for AST nodes.
 */
abstract public class NodeVisitor<T> implements IExpressionVisitor<T>, IStatementVisitor<T>, ITypeVisitor<T> {
	/**
	 * Holds the environment object.
	 */
	private final Environment environment;

	/**
	 * Constructs a new NodeVisitor.
	 */
	public NodeVisitor() {
		this.environment = new Environment();
	}

	/**
	 * Retrieves the environment.
	 *
	 * @return Environment object.
	 */
	public Environment getEnvironment() {
		return this.environment;
	}
}
