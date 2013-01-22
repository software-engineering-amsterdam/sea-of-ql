package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.interpreter.Env;
import org.uva.sea.ql.interpreter.Value;

public abstract class Expr implements ASTNode {
	
	public abstract Value interpret();
	
	public abstract Type typeOf(Env env);

}
