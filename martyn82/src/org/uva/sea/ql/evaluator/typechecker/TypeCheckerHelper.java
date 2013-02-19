package org.uva.sea.ql.evaluator.typechecker;

import org.uva.sea.ql.ast.Node;
import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.evaluator.environment.TypeEnvironment;
import org.uva.sea.ql.evaluator.environment.TypeError;

class TypeCheckerHelper {
	private final static String ERROR_TYPE_MISMATCH = "Both sides of %s must be of type %s, found %s";
	private final static String ERROR_INCOMPATIBLE_TYPE = "Invalid type at %s: expected %s, but was %s";
	private final static String ERROR_UNDEFINED_VAR = "Undefined variable: %s";
	private final static String ERROR_DECLARED_VAR = "Variable %s is already declared.";

	private final TypeEnvironment environment;

	public TypeCheckerHelper( TypeEnvironment environment ) {
		this.environment = environment;
	}

	public Type typeOf( Expression expression ) {
		return ExpressionTypeResolver.typeOf( expression, this.environment );
	}

	private void addError( int code, String message, Node node ) {
		this.environment.addError( new TypeError( code, message, node ) );
	}

	public void addIncompatibleTypesError( String nodeName, String expectedType, String actualType, Node node ) {
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

	public void addIncompatibleTypeError( String nodeName, String expectedType, String actualType, Node node ) {
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

	public void addUndefinedError( String nodeName, Node node ) {
		this.addError(
			TypeError.TYPE_UNDEFINED,
			String.format(
				ERROR_UNDEFINED_VAR,
				nodeName
			),
			node
		);
	}

	public void addAlreadyDeclaredError( String nodeName, Node node ) {
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
