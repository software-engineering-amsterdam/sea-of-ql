package org.uva.sea.ql.evaluator.typechecker;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.evaluator.Environment;
import org.uva.sea.ql.visitor.ASTNodeVisitor;

/**
 * Represents a type resolver.
 */
abstract public class TypeResolver extends ASTNodeVisitor<Type> {
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
