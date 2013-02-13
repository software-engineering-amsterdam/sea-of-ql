package org.uva.sea.ql.ast.expressions.binary;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.visitor.Visitor;

/**
 * Class: BinExpr.
 * @author Danny
 *
 * BinExpr: binary expression
 */
public abstract class BinExpr extends Expr {
	// Expr left and right
	private final Expr 	left, 
				 		right;
	
	/**
	 * Constructor 
	 * @param l - the left expr
	 * @param r - the right expr
	 */
	public BinExpr(Expr l, Expr r){
		this.left = l;
		this.right = r;
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
	 * accept()
	 * @param visitor
	 */
	@Override
	public void accept(Visitor visitor){
		visitor.visit(this);
	}
}
