package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.ASTVisitor;

public abstract class Expr implements ASTNode {
	
	public abstract void accept(ASTVisitor visitor);

}
