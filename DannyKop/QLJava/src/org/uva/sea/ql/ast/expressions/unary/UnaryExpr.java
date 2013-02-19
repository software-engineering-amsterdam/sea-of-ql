package org.uva.sea.ql.ast.expressions.unary;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.visitor.Visitor;

/**
 * Class: UnaryExpr
 * @author Danny
 *
 */
public abstract class UnaryExpr extends Expr {
	// The expression
	private final Expr argument;
	
	/**
	 * UnaryExpr
	 * @param expr - the expr
	 */
	public UnaryExpr(Expr expr){
		this.argument = expr;
	}
	
	/**
	 * getArgument
	 * @return expr 
	 */
	public Expr getArgument(){
		return this.argument;
	}
	/**
	 * accept()
	 * @param visitor
	 */
	@Override
	public <T> T accept(Visitor<T> visitor){
		return visitor.visit(this);
	}
}
