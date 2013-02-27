package org.uva.sea.ql.ast.expression.unary;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.visitor.ASTVisitor;

public class Neg extends UnaryExpr {
	
	public Neg(final Expression expr){
		super(expr);
	}
	
	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
	
}
