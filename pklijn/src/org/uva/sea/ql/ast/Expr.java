package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.values.Value;

public abstract class Expr implements ASTNode {

	public abstract Value eval();
}
