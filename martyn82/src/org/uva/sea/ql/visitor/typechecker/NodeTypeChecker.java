package org.uva.sea.ql.visitor.typechecker;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.eval.Environment;
import org.uva.sea.ql.visitor.NodeVisitor;

/**
 * Represents a type checker visitor.
 */
public class NodeTypeChecker extends NodeVisitor<Boolean> {
	/**
	 * Holds the environment object.
	 */
	private final Environment environment;

	protected final TypeResolver resolver;


	public NodeTypeChecker( Environment environment ) {
		this.environment = environment;
		this.resolver = new TypeResolver();
	}

	/**
	 * Constructs a new NodeTypeChecker instance.
	 */
	public NodeTypeChecker() {
		this.environment = new Environment();
		this.resolver = new TypeResolver();
	}

	/**
	 * Retrieves the environment.
	 *
	 * @return Environment object.
	 */
	public Environment getEnvironment() {
		return this.environment;
	}

	protected boolean checkBothNumber( Type one, Type two ) {
		return (
			one instanceof org.uva.sea.ql.ast.type.Number
			&& two instanceof org.uva.sea.ql.ast.type.Number
		);
	}

	protected boolean checkBothBoolean( Type one, Type two ) {
		return (
			one instanceof org.uva.sea.ql.ast.type.Bool
			&& two instanceof org.uva.sea.ql.ast.type.Bool
		);
	}

	protected boolean checkBothSame( Type one, Type two ) {
		return one.getClass() == two.getClass();
	}
}
