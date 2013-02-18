package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.ast.Node;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.typechecker.TypeEnvironment;
import org.uva.sea.ql.visitor.ExpressionVisitor;

public abstract class Expression extends Node {
	
	public abstract Type typeOf(TypeEnvironment typeEnv);
	public abstract <T> T accept(ExpressionVisitor<T> visitor);
	public abstract String getRepresentation();
}
