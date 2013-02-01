package org.uva.sea.ql.evaluator.typechecker;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.evaluator.Environment;
import org.uva.sea.ql.visitor.NodeVisitor;

/**
 * Represents a type resolver.
 */
public class TypeResolver extends NodeVisitor<Type> {
	/**
	 * Holds the environment.
	 */
	protected final Environment environment;

	/**
	 * Constructs a new TypeResolver.
	 *
	 * @param environment
	 */
	protected TypeResolver( Environment environment ) {
		this.environment = environment;
	}
}
