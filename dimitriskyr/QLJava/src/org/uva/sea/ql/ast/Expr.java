package org.uva.sea.ql.ast;

import java.util.Map;

import org.uva.sea.ql.visitor.ICheckExprVisitor;

public abstract class Expr implements ASTNode {
	public abstract Type typeOf(Map<String, Type> typeEnv);

	public abstract <T> T accept(ICheckExprVisitor<T> visitor);

}
