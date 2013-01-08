package org.uva.sea.ql.ast;

public abstract class Expr<T> implements ASTNode {

	public abstract T getValue();
}
