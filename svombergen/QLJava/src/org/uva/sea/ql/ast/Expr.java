package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.statements.types.Type;
import org.uva.sea.ql.visitor.IExpressionVisitor;
import org.uva.sea.ql.visitor.gui.Environment;

public abstract class Expr {
	public abstract <T> T accept(IExpressionVisitor<T> v);
	public abstract Type typeOf();
	public Type typeOf(Environment envir) {
		return typeOf();
	}
}
