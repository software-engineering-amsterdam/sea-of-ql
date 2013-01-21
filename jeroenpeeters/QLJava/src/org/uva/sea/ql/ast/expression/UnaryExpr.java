package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.parser.ASTVisitor;


public abstract class UnaryExpr extends Expression {

	protected final Expression expr;
	
	public UnaryExpr(final Expression expr){
		this.expr = expr;
	}
	
	public void accept(ASTVisitor v){
		v.visit(this);
	}

	public Expression getExpr() {
		return expr;
	}
	
}