package org.uva.sea.ql.ast.expression.binary;

import org.uva.sea.ql.ast.ASTVisitor;
import org.uva.sea.ql.ast.expression.Expression;

public class GEq extends BinaryExpr  {
	
	public GEq(final Expression lhs, final Expression rhs){
		super(lhs, rhs);
	}
	
	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
	
}
