package org.uva.sea.ql.evaluate.typecheck;

import org.uva.sea.ql.ast.Node;

class TypeErrorFactory {
	private final static String ERROR_UNDEFINED_VAR = "Undefined variable: %s";
	private final static String ERROR_INCOMPATIBLE_TYPE = "Invalid type at %s: expected %s, but was %s";
	private final static String ERROR_TYPE_MISMATCH = "Both sides of %s must be of type %s, found %s";
	private final static String ERROR_DECLARED_VAR = "Variable %s is already declared.";

	public static TypeError createUndefinedError( String nodeName, Node node ) {
		return new TypeError(
			TypeError.TYPE_UNDEFINED,
			String.format(
				ERROR_UNDEFINED_VAR,
				nodeName
			),
			node
		);
	}

	public static TypeError createAlreadyDeclaredError( String nodeName, Node node ) {
		return new TypeError(
			TypeError.TYPE_ERROR,
			String.format(
				ERROR_DECLARED_VAR,
				nodeName
			),
			node
		);
	}

	public static TypeError createIncompatibleTypeError(
		String nodeName, String expectedType, String actualType, Node node
	) {
		return new TypeError(
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

	public static TypeError createIncompatibleTypesError(
		String nodeName, String expectedType, String actualType, Node node
	) {
		return new TypeError(
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
}
