package org.uva.sea.ql.ast.expr;

import java.util.Map;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.expr.primary.Ident;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.visitor.ExpressionVisitor;

public abstract class Expr implements ASTNode {
	public abstract <T> T accept(ExpressionVisitor<T> visitor);
	public abstract Type typeOf(Map<Ident, Type> typeEnv);
}
