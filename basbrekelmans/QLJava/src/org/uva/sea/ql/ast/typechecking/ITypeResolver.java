package org.uva.sea.ql.ast.typechecking;

import org.uva.sea.ql.ast.expressions.Expression;
import org.uva.sea.ql.ast.types.Type;

public interface ITypeResolver {
	Type getType(Expression expression);
}
