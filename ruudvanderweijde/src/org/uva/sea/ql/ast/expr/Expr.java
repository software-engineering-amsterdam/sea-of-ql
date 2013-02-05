package org.uva.sea.ql.ast.expr;

import java.util.Map;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.expr.primary.Ident;
import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.visitor.IExpressionVisitor;
import org.uva.sea.ql.visitor.IFormVisitor;

public abstract class Expr implements ASTNode {
	public abstract <T> T accept(IExpressionVisitor<T> visitor);
	public abstract Type typeOf(Map<Ident, Type> typeEnv);
//	public abstract Type eval(Map<Ident, Type> typeEnv);
	
	@Override
	public void accept(IFormVisitor visitor) {
	}
}
