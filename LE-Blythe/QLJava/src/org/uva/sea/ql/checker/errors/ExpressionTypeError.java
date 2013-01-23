package org.uva.sea.ql.checker.errors;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.types.Type;

public class ExpressionTypeError extends Error{

	public ExpressionTypeError(Expr e, Type type) {
		super(String.format("%s does not have type %s\n", expressionToString(e), type.toString()));
	}
}
