package org.uva.sea.ql.ast.expression;

import java.util.Map;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitors.ExpressionVisitor;

public abstract class Expr implements ASTNode {
	
	public abstract Type typeOf(Map<Ident, Type> typeEnv);

	public abstract <T> T accept(ExpressionVisitor<T> visitor);
}