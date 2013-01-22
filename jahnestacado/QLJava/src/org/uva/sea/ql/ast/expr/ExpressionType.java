package org.uva.sea.ql.ast.expr;

import java.util.Map;

import org.uva.sea.ql.ast.types.Type;

public interface ExpressionType {
	
	 public abstract Type isOfType(Map<Ident, Type> typeEnv);
}
