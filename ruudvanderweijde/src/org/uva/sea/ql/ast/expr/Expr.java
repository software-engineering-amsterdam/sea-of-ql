package org.uva.sea.ql.ast.expr;

import java.util.Map;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.expr.primary.Ident;
import org.uva.sea.ql.ast.type.Type;

public abstract class Expr implements ASTNode {
	public abstract Type typeOf(Map<Ident, Type> typeEnv);
}
