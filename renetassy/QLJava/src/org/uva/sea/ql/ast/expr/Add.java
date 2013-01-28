package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.ASTVisitor;

public class Add extends Binary {

	public Add(Expr result, Expr rhs) {
		super(result, rhs);	
	}
	
	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}

}
