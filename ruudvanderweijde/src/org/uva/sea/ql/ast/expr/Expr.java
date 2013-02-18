package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.visitor.IExpressionVisitor;
import org.uva.sea.ql.visitor.typeCheck.TypeMapper;

public abstract class Expr {
	public abstract <T> T accept(IExpressionVisitor<T> visitor);
	public abstract Type typeOf(TypeMapper typeMapper);
}
