package org.uva.sea.ql.ast;

import java.util.Map;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.visitor.ExpressionVisitor;

public abstract class Expression extends Node {
	
	public abstract Type typeOf(Map<Identifier, Type> typeEnv);
	public abstract <T> T accept(ExpressionVisitor<T> visitor);
	
}
