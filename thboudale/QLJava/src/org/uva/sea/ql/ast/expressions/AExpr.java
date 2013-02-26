package org.uva.sea.ql.ast.expressions;

import java.util.Map;
import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.types.AType;
import org.uva.sea.ql.visitor.IExprVisitor;

public abstract class AExpr implements ASTNode {
	
	public abstract AType typeOf(Map<Ident, AType> typeEnv);
	public abstract <T> T accept(IExprVisitor<T> visitor);
}