package org.uva.sea.ql.ast.expr;

import java.util.Map;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.IExprVisitor;

public abstract class Expr implements ASTNode {
	
	public abstract Type typeOf(Map<String, Type> typeEnv);
	public abstract <T> T accept(IExprVisitor<T> visitor);
		
}
