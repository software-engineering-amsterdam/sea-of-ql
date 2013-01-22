package org.uva.sea.ql.ast.nodes;

import java.util.Map;


import org.uva.sea.ql.ast.type.*;

public abstract class Expr implements ASTNode {

	public abstract Type typeOf(Map<Ident, Type> typeEnv);
	//public abstract void printExprType();
	
	
}
