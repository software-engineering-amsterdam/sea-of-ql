package org.uva.sea.ql.ast.expression;

import java.util.Map;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.type.Type;

public abstract class Expression implements ASTNode {

	public abstract <T> T accept(ExpressionVisitor<T> visitor);
	
	public abstract Type typeOf(Map<Identifier, Type> typeEnv);
	
}