package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.parser.ASTVisitor;


public abstract class BinaryExpr extends Expression {

	protected final Expression lhs, rhs;
	
	public BinaryExpr(final Expression lhs, final Expression rhs){
		this.lhs = lhs;
		this.rhs = rhs;
	}
	
	public void accept(ASTVisitor v){
		v.visit(this);
	}

	public Expression getLhs() {
		return lhs;
	}

	public Expression getRhs() {
		return rhs;
	}
	
}