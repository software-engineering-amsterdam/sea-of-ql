package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitors.typechecker.Visitor;
import org.uva.sea.ql.check.TypeEnvironment;

public abstract class Expression implements ASTNode {
	
	public abstract Type typeOf(TypeEnvironment typeEnvironment);
	
	public abstract <T> T accept(Visitor<T> visitor);
	
}