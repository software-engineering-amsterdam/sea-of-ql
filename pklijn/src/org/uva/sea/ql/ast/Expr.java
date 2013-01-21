package org.uva.sea.ql.ast;

import java.util.Map;

import org.uva.sea.ql.ast.values.Value;
import org.uva.sea.ql.ast.types.Type;

public abstract class Expr implements ASTNode {
	
	public abstract Type typeOf(Map<Ident, Type> typeEnv);

	public abstract Value eval();
}
