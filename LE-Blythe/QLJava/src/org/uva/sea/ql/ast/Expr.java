package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.util.Environment;

public abstract class Expr implements ASTNode, IVisitableExpr {
	
	public abstract Type typeOf(Environment<Ident, Type> env);
}
