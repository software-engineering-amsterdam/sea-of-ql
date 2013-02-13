package org.uva.sea.ql.ast.expr;

import java.util.Map;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.visitor.ExpressionVisitor;

public abstract class Expr extends ASTNode {

	//COMPUTES TYPES !
	public abstract Type typeOf(Map<Ident, Type> typeEnv);
	
	
	//For double dispatch, accept visitor
	 public abstract <T> T accept(ExpressionVisitor<T> visitor);
	 
	@Override
	public String toString() {
		return " Expr "+this.getClass().toString();
	}
}
