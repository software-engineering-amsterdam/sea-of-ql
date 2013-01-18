package org.uva.sea.ql.ast.expressions.binary;

import org.uva.sea.ql.ast.Expr;

/**
 * Class: BinExpr
 * @author Danny
 *
 * BinExpr: binary expression
 */
public class BinExpr extends Expr {
	// Expr left and right
	private final Expr 	left, 
				 		right;
	
	// The operator of the expr
	protected final String op;
	
	/**
	 * Constructor
	 * @param l - the left expr
	 * @param r - the right expr
	 */
	public BinExpr(Expr l, Expr r){
		this(l, r, null);
	}
	
	/**
	 * Constructor 
	 * @param l - the left expr
	 * @param r - the right expr
	 * @param op - the operator value as a string or null 
	 */
	public BinExpr(Expr l, Expr r, String op){
		this.left = l;
		this.right = r;
		this.op = op;
	}
	
	/**
	 * getLeft()
	 * @return left
	 */
	public Expr getLeft(){
		return this.left;
	}
	/**
	 * getRight()
	 * @return right
	 */
	public Expr getRight(){
		return this.right;
	}
	
	/**
	 * getOperator
	 * @return String - the operator or null when no value is given
	 */
	public String getOperator(){
		return this.op;
	}

}
