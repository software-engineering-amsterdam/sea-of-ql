package org.uva.sea.ql.ast.expressions;

import java.util.Map;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.types.Type;

public abstract class Expr implements ASTNode {	

	public abstract <T> T accept(ExprVisitor<T> visitor);
	
	public abstract Type typeOf(Map<String, Type> typeEnvironment);

}
