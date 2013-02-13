package org.uva.sea.ql.parser.errors;

import org.uva.sea.ql.ast.expression.Expr;

public class OperatorTypeMismatchError extends SemanticError {
	private final static String FORMAT =
			"Operator type mismatch: %s not defined for %s and %s";
	
	public OperatorTypeMismatchError(String op, String lhsType, String rhsType,
			Expr expression)
	{	
		super(String.format(FORMAT, op, lhsType, rhsType), expression);
	}
}
