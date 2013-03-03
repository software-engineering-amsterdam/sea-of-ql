package org.uva.sea.ql.ast.expression.binary;

import org.uva.sea.ql.ast.ASTVisitor;
import org.uva.sea.ql.ast.expression.Expression;

public class NEq extends BinaryExpr {
	
	public NEq(final Expression lhs, final Expression rhs){
		super(lhs, rhs);
	}
	
	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
	
}
