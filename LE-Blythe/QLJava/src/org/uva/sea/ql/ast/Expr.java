package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitor.IVisitableExpr;
import org.uva.sea.ql.ast.visitor.IVisitorExpr;
import org.uva.sea.ql.util.Environment;

public abstract class Expr implements ASTNode, IVisitableExpr {
	
	public abstract <T> T accept(IVisitorExpr<T> visitor);
	public abstract Type typeOf(Environment env);
}
