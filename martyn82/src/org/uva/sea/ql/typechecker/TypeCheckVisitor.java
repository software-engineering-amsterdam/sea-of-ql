package org.uva.sea.ql.typechecker;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.eval.Environment;
import org.uva.sea.ql.visitor.NodeVisitor;

/**
 * Represents a type checker visitor.
 */
public class TypeCheckVisitor extends NodeVisitor<Boolean> {
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
	 * Retrieves the type resolver.
	 *
	 * @return Type resolver.
	 */
	protected ExpressionTypeResolver getResolver() {
		return this.resolver;
	}

	/**
	 * Determines whether both types are numeric.
	 *
	 * @param one
	 * @param two
	 *
	 * @return True if both are numeric, false otherwise.
	 */
	protected boolean checkBothNumber( Type one, Type two ) {
		return (
			one instanceof org.uva.sea.ql.ast.type.Number
			&& two instanceof org.uva.sea.ql.ast.type.Number
		);
	}

	/**
	 * Determines whether both types are boolean.
	 *
	 * @param one
	 * @param two
	 *
	 * @return True if both are boolean, false otherwise.
	 */
	protected boolean checkBothBoolean( Type one, Type two ) {
		return (
			one instanceof org.uva.sea.ql.ast.type.Bool
			&& two instanceof org.uva.sea.ql.ast.type.Bool
		);
	}

	/**
	 * Determines whether both types are the same.
	 *
	 * @param one
	 * @param two
	 *
	 * @return True if both are the same, false otherwise.
	 */
	protected boolean checkBothSame( Type one, Type two ) {
		return one.getClass() == two.getClass();
	}
}
