package org.uva.sea.ql.ast;

import java.util.Map;

import org.uva.sea.ql.ast.expressions.literal.Ident;
import org.uva.sea.ql.ast.visitors.checkexpr.Visitor;

public abstract class Expr implements ASTNode {
	
	public abstract Type typeOf(Map<Ident, Type> typeEnv);
	
	public abstract <T> T accept(Visitor<T> visitor);
	
}