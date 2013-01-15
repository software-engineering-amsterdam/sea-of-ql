package org.uva.sea.ql.ast;

import org.uva.sea.ql.interpreter.Value;

public abstract class Expr implements ASTNode {
	
	public abstract Value interpret();

}
