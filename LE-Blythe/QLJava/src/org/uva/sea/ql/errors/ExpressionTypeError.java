package org.uva.sea.ql.errors;

import org.uva.sea.ql.ast.Expr;

public class ExpressionTypeError extends FormCheckerError{
	private static final long serialVersionUID = 3L;
	
	public ExpressionTypeError(Expr e, Class<?> type) {
		super(String.format("Expression %s does not have type %s\n", e.getClass().getName(), type.getName()));
	}
}
