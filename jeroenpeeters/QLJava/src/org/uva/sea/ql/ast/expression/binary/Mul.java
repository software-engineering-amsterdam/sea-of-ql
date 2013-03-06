package org.uva.sea.ql.ast.expression.binary;

import org.uva.sea.ql.ast.ASTVisitor;
import org.uva.sea.ql.ast.expression.Expression;

public class Mul extends BinaryExpr {
	
	public Mul(final Expression lhs, final Expression rhs){
		super(lhs, rhs);
	}
	
	public void accept(ASTVisitor v){
		v.visit(this);
	}
	
}
