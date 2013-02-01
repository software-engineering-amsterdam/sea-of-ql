package org.uva.sea.ql.typechecker;

import org.uva.sea.ql.ast.Node;
import org.uva.sea.ql.visitor.Environment;
import org.uva.sea.ql.visitor.NodeVisitor;

/**
 * Represents a type checker visitor.
 */
abstract public class TypeCheckVisitor extends NodeVisitor<Boolean> {
	private final static String ERROR_TYPE_MISMATCH = "Both sides of %s must be of type %s, found %s";
	private final static String ERROR_INCOMPATIBLE_TYPE = "Invalid type: expected %s, but was %s";
	private final static String ERROR_UNDEFINED_VAR = "Undefined variable: %s";
	private final static String ERROR_DECLARED_VAR = "Variable %s is already declared.";

	/**
	 * Holds the expression type resolver.
	 */
	protected final ExpressionTypeResolver resolver;

	/**
	 * Holds the environment.
	 */
	protected final Environment environment;

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
	 * Adds a TypeError to the list.
	 *
	 * @param code
	 * @param message
	 * @param node
	 */
	private void addError( int code, String message, Node node ) {
		this.environment.addError( new TypeError( code, message, node ) );
	}

	/**
	 * Adds a TypeError to the error list.
	 *
	 * @param nodeName     The name of the node.
	 * @param expectedType The name of the type that was expected.
	 * @param actualType   The name of the type that was encountered.
	 * @param node         The node at which the error occurred.
	 */
	protected void addIncompatibleTypesError( String nodeName, String expectedType, String actualType, Node node ) {
		this.addError(
			TypeError.TYPE_MISMATCH,
			String.format(
				ERROR_TYPE_MISMATCH,
				nodeName,
				expectedType,
				actualType
			),
			node
		);
	}

	/**
	 * Adds a TypeError to the error list.
	 *
	 * @param nodeName     The name of the node.
	 * @param expectedType The name of the type that was expected.
	 * @param actualType   The name of the type that was encountered.
	 * @param node         The node at which the error occurred.
	 */
	protected void addIncompatibleTypeError( String nodeName, String expectedType, String actualType, Node node ) {
		this.addError(
			TypeError.TYPE_INVALID,
			String.format(
				ERROR_INCOMPATIBLE_TYPE,
				nodeName,
				expectedType,
				actualType
			),
			node
		);
	}

	/**
	 * Adds a TypeError referring to an undefined variable to the error list.
	 *
	 * @param nodeName The name of the variable.
	 * @param node     The node at which the error occurred.
	 */
	protected void addUndefinedError( String nodeName, Node node ) {
		this.addError(
			TypeError.TYPE_UNDEFINED,
			String.format(
				ERROR_UNDEFINED_VAR,
				nodeName
			),
			node
		);
	}

	/**
	 * Adds a TypeError referring to an already declared variable.
	 *
	 * @param nodeName The name of the variable.
	 * @param node     The node at which the error occurred.
	 */
	protected void addAlreadyDeclaredError( String nodeName, Node node ) {
		this.addError(
			TypeError.TYPE_ERROR,
			String.format(
				ERROR_DECLARED_VAR,
				nodeName
			),
			node
		);
	}
 }
