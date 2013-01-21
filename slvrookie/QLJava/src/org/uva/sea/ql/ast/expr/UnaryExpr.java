package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.visitor.Context;
import org.uva.sea.ql.visitor.Visitor;

public class UnaryExpr extends Expr implements ASTNode{

	private final Expr arg;

	protected UnaryExpr(Expr arg) {
		this.arg = arg;
	}

	public Expr getArg() {
		return arg;
	}



	@Override
	public void accept(Visitor visitor, Context context) {
		visitor.visit(this, context);
		
	}
	
}
