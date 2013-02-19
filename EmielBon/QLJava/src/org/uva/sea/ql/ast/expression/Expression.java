package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.ast.Node;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.typechecker.TypeEnvironment;

public abstract class Expression extends Node {
	
	public abstract Type typeOf(TypeEnvironment env);
	public abstract <T> T accept(ExpressionVisitor<T> visitor);
	public abstract String getRepresentation();
	
}
