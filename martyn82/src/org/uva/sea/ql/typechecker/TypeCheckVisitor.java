package org.uva.sea.ql.typechecker;

import org.uva.sea.ql.ast.Node;
import org.uva.sea.ql.eval.Environment;
import org.uva.sea.ql.eval.Error;
import org.uva.sea.ql.visitor.NodeVisitor;

/**
 * Represents a type checker visitor.
 */
abstract public class TypeCheckVisitor extends NodeVisitor<Boolean> {
	/**
	 * Holds the environment object.
	 */
	private final Environment environment;

	/**
	 * Holds the expression type resolver.
	 */
	private final ExpressionTypeResolver resolver;

	/**
	 * Constructs a new instance.
	 *
	 * @param environment
	 */
	public TypeCheckVisitor( Environment environment ) {
		this.environment = environment;
		this.resolver = new ExpressionTypeResolver( this.environment );
	}

	/**
	 * Retrieves the environment.
	 *
	 * @return Environment object.
	 */
	public Environment getEnvironment() {
		return this.environment;
	}

	/**
	 * Adds an error.
	 *
	 * @param message
	 * @param node
	 */
	protected void addError( String message, Node node ) {
		this.environment.addError( new Error( message, node ) );
	}

	/**
	 * Retrieves the type resolver.
	 *
	 * @return Type resolver.
	 */
	protected ExpressionTypeResolver getResolver() {
		return this.resolver;
	}
}
