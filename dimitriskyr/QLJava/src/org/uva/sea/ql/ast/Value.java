package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.visitor.ICheckExprVisitor;

public abstract class Value extends Expr {
	public abstract <T> T accept(ICheckExprVisitor<T> visitor); 

}
