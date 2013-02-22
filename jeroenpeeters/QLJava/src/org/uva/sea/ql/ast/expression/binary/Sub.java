package org.uva.sea.ql.ast.expression.binary;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.visitor.ASTVisitor;

public class Sub extends BinaryExpr {
	
	public Sub(final Expression lhs, final Expression rhs){
		super(lhs, rhs);
	}
	
	public void accept(ASTVisitor v){
		v.visit(this);
	}
	
}
