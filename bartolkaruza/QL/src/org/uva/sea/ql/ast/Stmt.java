package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.visitor.NodeVisitor;

public class Stmt implements ASTNode {
	
	public Stmt(Expr expression, Question questions) {
		
	}

	@Override
	public void accept(NodeVisitor visitor) {
	}

}
