package org.uva.sea.ql.ast.expressions.unary;

import org.uva.sea.ql.ast.Expr;

/**
 * Class: UnaryExpr
 * @author Danny
 *
 */
public class UnaryExpr extends Expr {
	
	// The operator of the expr
	protected final String op;
	
	// The expression
	private final Expr expr;
	
	/**
	 * UnaryExpr
	 * @param expr - the expr
	 */
	public UnaryExpr(Expr expr){
		this(expr, null);
	}
	
	/**
	 * Constructor
	 * @param expr - the expr
	 * @param op - the string of the operator or call other constructor
	 */
	public UnaryExpr(Expr expr, String op) {
		this.op = op;
		this.expr = expr;	
	}
	/**
	 * getExpression
	 * @return expr 
	 */
	public Expr getExpression(){
		return this.expr;
	}

}
