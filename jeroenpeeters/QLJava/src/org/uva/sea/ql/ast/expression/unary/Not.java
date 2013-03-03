package org.uva.sea.ql.ast.expression.unary;

import org.uva.sea.ql.ast.ASTVisitor;
import org.uva.sea.ql.ast.expression.Expression;

public class Not extends UnaryExpr {
	
	public Not(final Expression expr){
		super(expr);
	}
	
	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
	
}
