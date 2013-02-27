package org.uva.sea.ql.checker;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.types.Type;

public class ErrorExpressionType extends Error{

	public ErrorExpressionType(Expr e, Type type) {
		super(String.format("%s does not have type %s\n", expressionToString(e), type.toString()));
	}
}
