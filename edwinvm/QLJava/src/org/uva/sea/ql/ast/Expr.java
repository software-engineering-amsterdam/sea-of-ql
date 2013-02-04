package org.uva.sea.ql.ast;

import java.util.Map;

import org.uva.sea.ql.ast.expressions.literal.Ident;

public abstract class Expr implements ASTNode {
	
	public abstract Type typeOf(Map<Ident, Type> typeEnv);
	
}